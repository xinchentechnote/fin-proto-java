package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ReportTest {
  @Test
  public void testEncodeDecode() {
    Report original = new Report();
    original.setPbu("11111111");
    original.setSetId(4);
    original.setReportIndex(8L);
    original.setBizId(4);
    original.setExecType("1");
    original.setBizPbu("11111111");
    original.setClOrdId("1111111111");
    original.setSecurityId("111111111111");
    original.setAccount("1111111111111");
    original.setOwnerType((byte) 1);
    original.setSide("1");
    original.setPrice(8L);
    original.setOrderQty(8L);
    original.setLeavesQty(8L);
    original.setCxlQty(8L);
    original.setOrdType("1");
    original.setTimeInForce("1");
    original.setOrdStatus("1");
    original.setCreditTag("11");
    original.setOrigClOrdId("1111111111");
    original.setClearingFirm("11111111");
    original.setBranchId("11111111");
    original.setOrdRejReason(4);
    original.setOrdCnfmId("1111111111111111");
    original.setOrigOrdCnfmId("1111111111111111");
    original.setTradeDate(4);
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Report decoded = new Report();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
