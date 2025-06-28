package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class CancelRejectTest {
  @Test
  public void testEncodeDecode() {
    CancelReject original = new CancelReject();
    original.setPbu("11111111");
    original.setSetId(4);
    original.setReportIndex(8L);
    original.setBizId(4);
    original.setBizPbu("11111111");
    original.setClOrdId("1111111111");
    original.setSecurityId("111111111111");
    original.setOrigClOrdId("1111111111");
    original.setBranchId("11111111");
    original.setCxlRejReason(4);
    original.setTradeDate(4);
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    CancelReject decoded = new CancelReject();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
