package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200615Test {
  @Test
  public void testEncodeDecode() {
    Extend200615 original = new Extend200615();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200615 decoded = new Extend200615();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
