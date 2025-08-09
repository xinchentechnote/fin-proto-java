package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportTest {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReport original = new TradeCaptureReport();
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setTradeReportId("1111111111");
    original.setTradeReportType((byte) 1);
    original.setTradeReportTransType((byte) 1);
    original.setTradeHandlingInstr("1");
    original.setTradeReportRefId("1111111111");
    original.setLastPx(8L);
    original.setLastQty(8L);
    original.setTrdType((short) 2);
    original.setTrdSubType((short) 2);
    original.setConfirmId(4);
    original.setSide("1");
    original.setPbuid("111111");
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setCounterPartyPbuid("111111");
    original.setCounterPartyAccountId("1111111111");
    original.setCounterPartyBranchId("11");
    original.setApplId("031");
    TradeCaptureReportExtend031 tradeCaptureReportExtend031 = new TradeCaptureReportExtend031();
    tradeCaptureReportExtend031.setMemberId("111111");
    tradeCaptureReportExtend031.setTraderCode("11111");
    tradeCaptureReportExtend031.setCounterPartyMemberId("111111");
    tradeCaptureReportExtend031.setCounterPartyTraderCode("11111");
    tradeCaptureReportExtend031.setSettlType("1");
    tradeCaptureReportExtend031.setSettlPeriod("1");
    tradeCaptureReportExtend031.setCashMargin("1");
    tradeCaptureReportExtend031.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setApplExtend(tradeCaptureReportExtend031);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReport decoded = new TradeCaptureReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
