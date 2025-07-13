package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend100201Test {
  @Test
  public void testEncodeDecode() {
    Extend100201 original = new Extend100201();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend100201 decoded = new Extend100201();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
