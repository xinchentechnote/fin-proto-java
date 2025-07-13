package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend204115Test {
  @Test
  public void testEncodeDecode() {
    Extend204115 original = new Extend204115();
    original.setCashMargin("1");
    original.setSettlType((short) 2);
    original.setSettlPeriod((byte) 1);
    original.setCounterpartyMemberId("111111");
    original.setCounterpartyInvestorType("11");
    original.setCounterpartyInvestorId("1111111111");
    original.setCounterpartyInvestorName(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setCounterpartyTraderCode("11111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend204115 decoded = new Extend204115();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
