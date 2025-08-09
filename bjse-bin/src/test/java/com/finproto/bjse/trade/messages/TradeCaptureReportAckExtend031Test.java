package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckExtend031Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAckExtend031 original = new TradeCaptureReportAckExtend031();
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
    TradeCaptureReportAckExtend031 decoded = new TradeCaptureReportAckExtend031();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
