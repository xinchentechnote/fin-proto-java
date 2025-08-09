package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder044Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder044 original = new ExtendNewOrder044();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder044 decoded = new ExtendNewOrder044();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
