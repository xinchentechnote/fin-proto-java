package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder045Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder045 original = new ExtendNewOrder045();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder045 decoded = new ExtendNewOrder045();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
