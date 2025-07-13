package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class BasicPacketTest {
  @Test
  public void testEncodeDecode() {
    BasicPacket original = new BasicPacket();
    original.setFieldI8((byte) 1);
    original.setFieldI16((short) 2);
    original.setFieldI32(4);
    original.setFieldI64(8L);
    original.setFieldChar("1");
    original.setFieldU8((byte) 1);
    original.setFieldU16((short) 2);
    original.setFieldU32(4);
    original.setFieldU64(8L);
    original.setFieldF32(4F);
    original.setFieldF64(8D);
    original.setFieldI8List(Arrays.asList((byte) 1));
    original.setFieldI16List(Arrays.asList((short) 2));
    original.setFieldI32List(Arrays.asList(4));
    original.setFieldI64List(Arrays.asList(8L));
    original.setFieldCharList(Arrays.asList("1"));
    original.setFieldU8List(Arrays.asList((byte) 1));
    original.setFieldU16List(Arrays.asList((short) 2));
    original.setFieldU32List(Arrays.asList(4));
    original.setFieldU64List(Arrays.asList(8L));
    original.setFieldF32List(Arrays.asList(4F));
    original.setFieldF64List(Arrays.asList(8D));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    BasicPacket decoded = new BasicPacket();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
