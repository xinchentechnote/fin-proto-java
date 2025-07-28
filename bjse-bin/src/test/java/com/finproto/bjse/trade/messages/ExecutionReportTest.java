package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExecutionReportTest {
  @Test
  public void testEncodeDecode() {
    ExecutionReport original = new ExecutionReport();
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
    original.setOrderId("1111111111111111");
    original.setClOrdId("1111111111");
    original.setExecId("1111111111111111");
    original.setExecType((byte) 1);
    original.setOrdStatus((byte) 1);
    original.setLastPx(8L);
    original.setLastQty(8L);
    original.setLeavesQty(8L);
    original.setCumQty(8L);
    original.setSide((byte) 1);
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setApplId("010");
    ReportExtend010 reportExtend010 = new ReportExtend010();
    reportExtend010.setCashMargin((byte) 1);
    reportExtend010.setSettlType((byte) 1);
    reportExtend010.setSettlPeriod((byte) 1);
    original.setApplExtend(reportExtend010);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecutionReport decoded = new ExecutionReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
