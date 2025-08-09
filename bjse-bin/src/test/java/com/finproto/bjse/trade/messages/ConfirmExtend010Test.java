package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend010Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend010 original = new ConfirmExtend010();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend010 decoded = new ConfirmExtend010();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
