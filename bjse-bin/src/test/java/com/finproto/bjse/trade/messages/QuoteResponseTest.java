package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class QuoteResponseTest {
  @Test
  public void testEncodeDecode() {
    QuoteResponse original = new QuoteResponse();
    original.setReportingPbuid("111111");
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setClOrdId("1111111111");
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setQuoteRespId("1111111111");
    original.setQuoteRespType((byte) 1);
    original.setSide("1");
    original.setValidUntilTime(8L);
    original.setQuoteType((byte) 1);
    original.setPriceType((byte) 1);
    QuoteResponse.Quote2 quote2 = new QuoteResponse.Quote2();
    quote2.setQuoteId("1111111111");
    quote2.setQuotePrice(8L);
    quote2.setQuoteQty(8L);
    original.setQuote2(Arrays.asList(quote2));
    original.setApplId("070");
    QuoteResponseExtend070 quoteResponseExtend070 = new QuoteResponseExtend070();
    quoteResponseExtend070.setCashMargin("1");
    original.setApplExtend(quoteResponseExtend070);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteResponse decoded = new QuoteResponse();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
