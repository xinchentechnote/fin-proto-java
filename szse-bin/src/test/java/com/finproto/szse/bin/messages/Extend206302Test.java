package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend206302Test {
  @Test
  public void testEncodeDecode() {
    Extend206302 original = new Extend206302();
    original.setRejectText("1111111111111111");
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setLotType("1");
    original.setImcrejectTextLen(4);
    original.setImcrejectText("example");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend206302 decoded = new Extend206302();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
