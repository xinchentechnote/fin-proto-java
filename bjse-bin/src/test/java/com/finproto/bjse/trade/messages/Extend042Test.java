package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend042Test {
  @Test
  public void testEncodeDecode() {
    Extend042 original = new Extend042();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend042 decoded = new Extend042();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
