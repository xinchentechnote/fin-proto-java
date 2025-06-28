package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend106301Test {
  @Test
  public void testEncodeDecode() {
    Extend106301 original = new Extend106301();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);
    original.setLotType((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend106301 decoded = new Extend106301();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
