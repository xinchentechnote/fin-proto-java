package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class QuoteStatusReportExtend070Test {
  @Test
  public void testEncodeDecode() {
    QuoteStatusReportExtend070 original = new QuoteStatusReportExtend070();
    original.setBranchId("11");
    original.setOrderId("1111111111111111");
    original.setExecId("1111111111111111");
    original.setQuoteRespId("1111111111");
    original.setPrivateQuote((byte) 1);
    original.setSide((byte) 1);
    original.setPriceType((byte) 1);
    original.setValidUntilTime(8L);
    original.setCashMargin((byte) 1);
    original.setCounterPartyPbuid("111111");
    original.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
    QuoteStatusReportExtend070.NoQuote noQuote = new QuoteStatusReportExtend070.NoQuote();
    noQuote.setQuoteId("1111111111");
    noQuote.setQuotePrice(8L);
    noQuote.setQuoteQty(8L);
    original.setNoQuote(Arrays.asList(noQuote));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteStatusReportExtend070 decoded = new QuoteStatusReportExtend070();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
