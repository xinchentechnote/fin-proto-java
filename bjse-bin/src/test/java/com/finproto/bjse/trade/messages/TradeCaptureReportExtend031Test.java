package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportExtend031Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportExtend031 original = new TradeCaptureReportExtend031();
    original.setMemberId("111111");
    original.setTraderCode("11111");
    original.setCounterPartyMemberId("111111");
    original.setCounterPartyTraderCode("11111");
    original.setSettlType("1");
    original.setSettlPeriod("1");
    original.setCashMargin("1");
    original.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportExtend031 decoded = new TradeCaptureReportExtend031();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
