package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder040Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder040 original = new ExtendNewOrder040();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder040 decoded = new ExtendNewOrder040();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
