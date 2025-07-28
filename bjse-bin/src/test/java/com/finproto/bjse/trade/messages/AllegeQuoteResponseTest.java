package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class AllegeQuoteResponseTest {
  @Test
  public void testEncodeDecode() {
    AllegeQuoteResponse original = new AllegeQuoteResponse();
    original.setPartitionNo(4);
    original.setReportIndex(8L);
    original.setApplId("111");
    original.setReportingPbuid("111111");
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setOrderId("1111111111111111");
    original.setExecId("1111111111111111");
    original.setClOrdId("1111111111");
    original.setAccountId("1111111111");
    original.setQuoteId("1111111111");
    original.setQuoteRespId("1111111111");
    original.setQuoteRespType((byte) 1);
    original.setPrivateQuote((byte) 1);
    original.setOrderQty(8L);
    original.setPrice(8L);
    original.setValidUntilTime(8L);
    original.setQuoteType((byte) 1);
    original.setPriceType((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    AllegeQuoteResponse decoded = new AllegeQuoteResponse();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
