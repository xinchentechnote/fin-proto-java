package com.finproto.codec;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class BinaryCodecTest {

    // Test implementation for the interface
    private static class TestBinaryCodec implements BinaryCodec {
        @Override
        public void encode(ByteBuf byteBuf) {
            // Simple implementation for testing
            writeFixedString(byteBuf, "test", 10);
        }

        @Override
        public void decode(ByteBuf byteBuf) {
            // Simple implementation for testing
            readFixedString(byteBuf, 10);
        }
    }

    @Test
    public void testWriteFixedString_NonNullValue() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        codec.writeFixedString(buffer, "hello", 8);

        assertEquals(8, buffer.readableBytes());
        byte[] result = new byte[8];
        buffer.readBytes(result);
        assertArrayEquals(new byte[] { 'h', 'e', 'l', 'l', 'o', 0, 0, 0 }, result);
    }

    @Test
    public void testWriteFixedString_NullValue() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        codec.writeFixedString(buffer, null, 5);

        assertEquals(5, buffer.readableBytes());
        byte[] result = new byte[5];
        buffer.readBytes(result);
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 0 }, result);
    }

    @Test
    public void testWriteFixedString_EmptyString() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        codec.writeFixedString(buffer, "", 4);

        assertEquals(4, buffer.readableBytes());
        byte[] result = new byte[4];
        buffer.readBytes(result);
        assertArrayEquals(new byte[] { 0, 0, 0, 0 }, result);
    }

    @Test
    public void testWriteFixedString_StringLongerThanLength() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        codec.writeFixedString(buffer, "this is too long", 5);

        assertEquals(5, buffer.readableBytes());
        byte[] result = new byte[5];
        buffer.readBytes(result);
        assertArrayEquals(new byte[] { 't', 'h', 'i', 's', ' ' }, result);
    }

    @Test
    public void testReadFixedString() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        // Write test data
        buffer.writeByte(0);
        buffer.writeBytes("hello".getBytes());
        buffer.writeByte(0);
        buffer.writeByte(0);

        String result = codec.readFixedString(buffer, 8);

        assertEquals("hello", result.trim());
        assertEquals(0, buffer.readableBytes());
    }

    @Test
    public void testReadFixedString_NonAscii() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        String testString = "こんにちは";
        byte[] bytes = testString.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);

        String result = codec.readFixedString(buffer, bytes.length);

        assertEquals(testString, result);
    }

    @Test
    public void testEncodeMethod() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        codec.encode(buffer);

        assertTrue(buffer.readableBytes() > 0);
        // Verify the encode method called writeFixedString properly
        String result = codec.readFixedString(buffer, 10);
        assertEquals("test", result.trim());
    }

    @Test
    public void testDecodeMethod() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        // Prepare test data - use same length as decode will read (10)
        codec.writeFixedString(buffer, "decode_test", 10);

        // Reset reader index for decode
        buffer.resetReaderIndex();

        // Should read the string we just wrote
        codec.decode(buffer);

        // Verify all bytes were read
        assertEquals(0, buffer.readableBytes());
    }

    @Test
    public void testInterfaceContract() {
        BinaryCodec codec = new TestBinaryCodec();
        ByteBuf buffer = Unpooled.buffer();

        // Test that encode writes to buffer
        int initialSize = buffer.readableBytes();
        codec.encode(buffer);
        assertTrue(buffer.readableBytes() > initialSize);

        // Test that decode reads from buffer
        int bytesToRead = buffer.readableBytes();
        codec.decode(buffer);
        assertEquals(0, buffer.readableBytes());
    }
}