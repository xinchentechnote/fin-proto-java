package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder010Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder010 original = new ExtendNewOrder010();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setCashMargin("1");
    original.setSettlType("1");
    original.setSettlPeriod("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder010 decoded = new ExtendNewOrder010();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
