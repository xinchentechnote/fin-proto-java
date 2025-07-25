package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class SubPacketTest {
  @Test
  public void testEncodeDecode() {
    SubPacket original = new SubPacket();
    original.setFieldU32(4);
    original.setFieldI16List(Arrays.asList((short) 2));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    SubPacket decoded = new SubPacket();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
