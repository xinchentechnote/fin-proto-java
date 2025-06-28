package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200115Test {
  @Test
  public void testEncodeDecode() {
    Extend200115 original = new Extend200115();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200115 decoded = new Extend200115();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
