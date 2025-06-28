package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend204129Test {
  @Test
  public void testEncodeDecode() {
    Extend204129 original = new Extend204129();
    original.setMemberId("111111");
    original.setInvestorType("11");
    original.setInvestorId("1111111111");
    original.setInvestorName(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setTraderCode("11111111");
    original.setSecondaryOrderId("1111111111111111");
    original.setBidTransType((short) 2);
    original.setBidExecInstType((short) 2);
    original.setLowLimitPrice(8L);
    original.setHighLimitPrice(8L);
    original.setMinQty(8L);
    original.setTradeDate(4);
    original.setSettlType((short) 2);
    original.setSettlPeriod((byte) 1);
    original.setPreTradeAnonymity((byte) 1);
    original.setCashMargin((byte) 1);
    original.setMemo(
        "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend204129 decoded = new Extend204129();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
