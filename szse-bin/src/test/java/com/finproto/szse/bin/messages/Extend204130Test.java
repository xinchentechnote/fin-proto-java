package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend204130Test {
  @Test
  public void testEncodeDecode() {
    Extend204130 original = new Extend204130();
    original.setMemberId("111111");
    original.setInvestorType("11");
    original.setInvestorId("1111111111");
    original.setInvestorName(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setTraderCode("11111111");
    original.setCounterpartyMemberId("111111");
    original.setCounterpartyInvestorType("11");
    original.setCounterpartyInvestorId("1111111111");
    original.setCounterpartyInvestorName(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setCounterpartyTraderCode("11111111");
    original.setSecondaryOrderId("1111111111111111");
    original.setBidTransType((short) 2);
    original.setBidExecInstType((short) 2);
    original.setSettlType((short) 2);
    original.setSettlPeriod((byte) 1);
    original.setCashMargin((byte) 1);
    original.setMemo(
        "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend204130 decoded = new Extend204130();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
