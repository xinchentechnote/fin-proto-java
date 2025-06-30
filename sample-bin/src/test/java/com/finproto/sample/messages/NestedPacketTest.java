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
    SubPacket subPacket0 = new SubPacket();
    subPacket0.setFieldU32(4);
    subPacket0.setFieldI16List(Arrays.asList((short) 2));
    original.setSubPacket(subPacket0);
    SubPacket subPacketList0 = new SubPacket();
    subPacketList0.setFieldU32(4);
    subPacketList0.setFieldI16List(Arrays.asList((short) 2));
    original.setSubPacketList(Arrays.asList(subPacketList0));
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
