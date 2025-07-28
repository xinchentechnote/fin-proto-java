package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckTest {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAck original = new TradeCaptureReportAck();
    original.setPartitionNo(4);
    original.setReportIndex(8L);
    original.setReportingPbuid("111111");
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setTradeId("1111111111111111");
    original.setTradeReportId("1111111111");
    original.setTradeReportType((byte) 1);
    original.setTradeReportTransType((byte) 1);
    original.setTradeHandlingInstr((byte) 1);
    original.setTradeReportRefId("1111111111");
    original.setTrdAckStatus((byte) 1);
    original.setTrdRptStatus((byte) 1);
    original.setTradeReportRejectReason((short) 2);
    original.setLastPx(8L);
    original.setLastQty(8L);
    original.setTrdType((short) 2);
    original.setTrdSubType((short) 2);
    original.setConfirmId(4);
    original.setExecId("1111111111111111");
    original.setSide((byte) 1);
    original.setPbuid("111111");
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setCounterPartyPbuid("111111");
    original.setCounterPartyAccountId("1111111111");
    original.setCounterPartyBranchId("11");
    original.setApplId("031");
    TradeCaptureReportAckExtend031 tradeCaptureReportAckExtend031 =
        new TradeCaptureReportAckExtend031();
    tradeCaptureReportAckExtend031.setMemberId("111111");
    tradeCaptureReportAckExtend031.setTraderCode("11111");
    tradeCaptureReportAckExtend031.setCounterPartyMemberId("111111");
    tradeCaptureReportAckExtend031.setCounterPartyTraderCode("11111");
    tradeCaptureReportAckExtend031.setSettlType((byte) 1);
    tradeCaptureReportAckExtend031.setSettlPeriod((byte) 1);
    tradeCaptureReportAckExtend031.setCashMargin((byte) 1);
    tradeCaptureReportAckExtend031.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setApplExtend(tradeCaptureReportAckExtend031);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportAck decoded = new TradeCaptureReportAck();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
