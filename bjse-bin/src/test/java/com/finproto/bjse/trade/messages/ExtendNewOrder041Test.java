package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder041Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder041 original = new ExtendNewOrder041();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder041 decoded = new ExtendNewOrder041();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
