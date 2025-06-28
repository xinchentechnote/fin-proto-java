package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend101701Test {
  @Test
  public void testEncodeDecode() {
    Extend101701 original = new Extend101701();
    original.setCashOrderQty(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend101701 decoded = new Extend101701();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
