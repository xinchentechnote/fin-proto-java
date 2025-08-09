package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class QuoteStatusReportTest {
  @Test
  public void testEncodeDecode() {
    QuoteStatusReport original = new QuoteStatusReport();
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
    original.setQuoteMsgId("1111111111");
    original.setAccountId("1111111111");
    original.setQuoteReqId("1111111111");
    original.setQuoteRjectReason(8L);
    original.setQuoteType((byte) 1);
    original.setBidPx(8L);
    original.setOfferPx(8L);
    original.setBidSize(8L);
    original.setOfferSize(8L);
    original.setApplId("070");
    QuoteStatusReportExtend070 quoteStatusReportExtend070 = new QuoteStatusReportExtend070();
    quoteStatusReportExtend070.setBranchId("11");
    quoteStatusReportExtend070.setOrderId("1111111111111111");
    quoteStatusReportExtend070.setExecId("1111111111111111");
    quoteStatusReportExtend070.setQuoteRespId("1111111111");
    quoteStatusReportExtend070.setPrivateQuote((byte) 1);
    quoteStatusReportExtend070.setSide("1");
    quoteStatusReportExtend070.setPriceType((byte) 1);
    quoteStatusReportExtend070.setValidUntilTime(8L);
    quoteStatusReportExtend070.setCashMargin("1");
    quoteStatusReportExtend070.setCounterPartyPbuid("111111");
    quoteStatusReportExtend070.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    QuoteStatusReportExtend070.Quote1 quote1 = new QuoteStatusReportExtend070.Quote1();
    quote1.setQuoteId("1111111111");
    quote1.setQuotePrice(8L);
    quote1.setQuoteQty(8L);
    quoteStatusReportExtend070.setQuote1(Arrays.asList(quote1));
    original.setApplExtend(quoteStatusReportExtend070);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteStatusReport decoded = new QuoteStatusReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
