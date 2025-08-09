package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder042Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder042 original = new ExtendNewOrder042();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder042 decoded = new ExtendNewOrder042();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
