package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend040Test {
  @Test
  public void testEncodeDecode() {
    Extend040 original = new Extend040();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend040 decoded = new Extend040();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
