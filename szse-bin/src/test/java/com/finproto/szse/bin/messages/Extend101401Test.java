package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend101401Test {
  @Test
  public void testEncodeDecode() {
    Extend101401 original = new Extend101401();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce((byte) 1);
    original.setPositionEffect((byte) 1);
    original.setCoveredOrUncovered((byte) 1);
    original.setContractAccountCode("111111");
    original.setSecondaryOrderId("1111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend101401 decoded = new Extend101401();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
