package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200402Test {
  @Test
  public void testEncodeDecode() {
    Extend200402 original = new Extend200402();
    original.setStopPx(8L);
    original.setMinQty(8L);
    original.setMaxPriceLevels((short) 2);
    original.setTimeInForce("1");
    original.setPositionEffect("1");
    original.setCoveredOrUncovered((byte) 1);
    original.setContractAccountCode("111111");
    original.setSecondaryOrderId("1111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200402 decoded = new Extend200402();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
