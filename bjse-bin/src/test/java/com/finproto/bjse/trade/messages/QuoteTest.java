package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class QuoteTest {
  @Test
  public void testEncodeDecode() {
    Quote original = new Quote();
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setQuoteMsgId("1111111111");
    original.setAccountId("1111111111");
    original.setQuoteReqId("1111111111");
    original.setQuoteType((byte) 1);
    original.setBidPx(8L);
    original.setOfferPx(8L);
    original.setBidSize(8L);
    original.setOfferSize(8L);
    original.setApplId("070");
    QuoteExtend070 quoteExtend070 = new QuoteExtend070();
    quoteExtend070.setBranchId("11");
    quoteExtend070.setQuoteId("1111111111");
    quoteExtend070.setQuoteRespId("1111111111");
    quoteExtend070.setPrivateQuote((byte) 1);
    quoteExtend070.setValidUntilTime(8L);
    quoteExtend070.setPriceType((byte) 1);
    quoteExtend070.setCashMargin("1");
    quoteExtend070.setCounterPartyPbuid("111111");
    quoteExtend070.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    original.setApplExtend(quoteExtend070);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Quote decoded = new Quote();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
