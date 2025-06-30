package com.finproto.sample.messages;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class RootPacketTest {
    @Test
    public void testEncodeDecode() {
        RootPacket original = new RootPacket();
        original.setMsgType((short)1);
        BasicPacket basicPacket = new BasicPacket();
        basicPacket.setFieldI8((byte)1);
        basicPacket.setFieldI16((short)2);
        basicPacket.setFieldI32(4);
        basicPacket.setFieldI64(8L);
        basicPacket.setFieldChar((byte)1);
        basicPacket.setFieldU8((byte)1);
        basicPacket.setFieldU16((short)2);
        basicPacket.setFieldU32(4);
        basicPacket.setFieldU64(8L);
        basicPacket.setFieldF32(4F);
        basicPacket.setFieldF64(8D);
        basicPacket.setFieldI8List(Arrays.asList((byte)1));
        basicPacket.setFieldI16List(Arrays.asList((short)2));
        basicPacket.setFieldI32List(Arrays.asList(4));
        basicPacket.setFieldI64List(Arrays.asList(8L));
        basicPacket.setFieldCharList(Arrays.asList((byte)1));
        basicPacket.setFieldU8List(Arrays.asList((byte)1));
        basicPacket.setFieldU16List(Arrays.asList((short)2));
        basicPacket.setFieldU32List(Arrays.asList(4));
        basicPacket.setFieldU64List(Arrays.asList(8L));
        basicPacket.setFieldF32List(Arrays.asList(4F));
        basicPacket.setFieldF64List(Arrays.asList(8D));
        original.setPayload(basicPacket);
        original.setChecksum(4);
        
        ByteBuf buffer = Unpooled.buffer();
        original.encode(buffer);
        RootPacket decoded = new RootPacket();
        decoded.decode(buffer);
        assertEquals(original, decoded);
    }
}
