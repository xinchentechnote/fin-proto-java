package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend103701Test {
  @Test
  public void testEncodeDecode() {
    Extend103701 original = new Extend103701();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend103701 decoded = new Extend103701();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
