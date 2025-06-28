package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200202Test {
  @Test
  public void testEncodeDecode() {
    Extend200202 original = new Extend200202();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200202 decoded = new Extend200202();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
