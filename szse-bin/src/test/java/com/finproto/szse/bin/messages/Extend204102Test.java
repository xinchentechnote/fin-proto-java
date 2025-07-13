package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend204102Test {
  @Test
  public void testEncodeDecode() {
    Extend204102 original = new Extend204102();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend204102 decoded = new Extend204102();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
