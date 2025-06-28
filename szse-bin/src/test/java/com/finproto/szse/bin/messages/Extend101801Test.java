package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend101801Test {
  @Test
  public void testEncodeDecode() {
    Extend101801 original = new Extend101801();
    original.setTenderer("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend101801 decoded = new Extend101801();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
