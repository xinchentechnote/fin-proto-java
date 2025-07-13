package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend100301Test {
  @Test
  public void testEncodeDecode() {
    Extend100301 original = new Extend100301();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend100301 decoded = new Extend100301();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
