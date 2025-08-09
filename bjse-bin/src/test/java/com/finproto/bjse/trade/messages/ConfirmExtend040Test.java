package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend040Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend040 original = new ConfirmExtend040();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend040 decoded = new ConfirmExtend040();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
