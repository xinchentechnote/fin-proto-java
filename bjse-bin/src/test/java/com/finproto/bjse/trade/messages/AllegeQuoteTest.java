package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class AllegeQuoteTest {
  @Test
  public void testEncodeDecode() {
    AllegeQuote original = new AllegeQuote();
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
    original.setExecId("1111111111111111");
    original.setClOrdId("1111111111");
    original.setAccountId("1111111111");
    original.setQuoteReqId("1111111111");
    original.setQuoteId("1111111111");
    original.setQuoteRespId("1111111111");
    original.setQuoteType((byte) 1);
    original.setBidPx(8L);
    original.setOfferPx(8L);
    original.setBidSize(8L);
    original.setOfferSize(8L);
    original.setPrivateQuote((byte) 1);
    original.setValidUntilTime(8L);
    original.setPriceType((byte) 1);
    original.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setApplId("070");
    AllegeQuoteExtend070 allegeQuoteExtend070 = new AllegeQuoteExtend070();
    allegeQuoteExtend070.setCashMargin((byte) 1);
    allegeQuoteExtend070.setCounterPartyPbuid("111111");
    original.setApplExtend(allegeQuoteExtend070);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    AllegeQuote decoded = new AllegeQuote();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
