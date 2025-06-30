package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class NestedPacketTest {
  @Test
  public void testEncodeDecode() {
    NestedPacket original = new NestedPacket();
    SubPacket subPacket = new SubPacket();
    subPacket.setFieldU32(4);
    subPacket.setFieldI16List(Arrays.asList((short) 2));
    original.setSubPacket(Arrays.asList(subPacket));
    NestedPacket.InerPacket inerPacket = new NestedPacket.InerPacket();
    inerPacket.setFieldU32(4);
    inerPacket.setFieldI16List(Arrays.asList((short) 2));
    original.setInerPacket(inerPacket);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    NestedPacket decoded = new NestedPacket();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
