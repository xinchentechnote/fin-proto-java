package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend044Test {
  @Test
  public void testEncodeDecode() {
    Extend044 original = new Extend044();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend044 decoded = new Extend044();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
