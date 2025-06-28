package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200602Test {
  @Test
  public void testEncodeDecode() {
    Extend200602 original = new Extend200602();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200602 decoded = new Extend200602();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
