package com.finproto.szse.bin.messages;

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
    original.setUserInfo("11111111");
    original.setOrderId("1111111111111111");
    original.setClOrdId("1111111111");
    original.setQuoteMsgId("1111111111");
    original.setExecId("1111111111111111");
    original.setExecType("1");
    original.setOrdStatus("1");
    original.setLastPx(8L);
    original.setLastQty(8L);
    original.setLeavesQty(8L);
    original.setCumQty(8L);
    original.setSide("1");
    original.setAccountId("111111111111");
    original.setBranchId("1111");
    original.setApplId("010");
    Extend200115 extend200115 = new Extend200115();
    extend200115.setCashMargin("1");
    original.setApplExtend(extend200115);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecutionReport decoded = new ExecutionReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
