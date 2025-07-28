package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend010Test {
  @Test
  public void testEncodeDecode() {
    Extend010 original = new Extend010();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);
    original.setCashMargin((byte) 1);
    original.setSettlType((byte) 1);
    original.setSettlPeriod((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend010 decoded = new Extend010();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
