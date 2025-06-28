package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200102Test {
  @Test
  public void testEncodeDecode() {
    Extend200102 original = new Extend200102();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200102 decoded = new Extend200102();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
