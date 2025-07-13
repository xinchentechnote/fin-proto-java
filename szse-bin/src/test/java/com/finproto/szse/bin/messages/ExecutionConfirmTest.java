package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExecutionConfirmTest {
  @Test
  public void testEncodeDecode() {
    ExecutionConfirm original = new ExecutionConfirm();
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
    original.setOrigClOrdId("1111111111");
    original.setExecId("1111111111111111");
    original.setExecType("1");
    original.setOrdStatus("1");
    original.setOrdRejReason((short) 2);
    original.setLeavesQty(8L);
    original.setCumQty(8L);
    original.setSide("1");
    original.setOrdType("1");
    original.setOrderQty(8L);
    original.setPrice(8L);
    original.setAccountId("111111111111");
    original.setBranchId("1111");
    original.setOrderRestrictions("1111");
    original.setApplId("010");
    Extend200102 extend200102 = new Extend200102();
    extend200102.setStopPx(8L);
    extend200102.setMinQty(8L);
    extend200102.setMaxPriceLevels((short) 2);
    extend200102.setTimeInForce("1");
    extend200102.setCashMargin("1");
    original.setApplExtend(extend200102);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecutionConfirm decoded = new ExecutionConfirm();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
