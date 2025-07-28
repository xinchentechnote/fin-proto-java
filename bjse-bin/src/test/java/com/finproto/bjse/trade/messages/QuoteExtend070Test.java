package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class QuoteExtend070Test {
  @Test
  public void testEncodeDecode() {
    QuoteExtend070 original = new QuoteExtend070();
    original.setBranchId("11");
    original.setQuoteId("1111111111");
    original.setQuoteRespId("1111111111");
    original.setPrivateQuote((byte) 1);
    original.setValidUntilTime(8L);
    original.setPriceType((byte) 1);
    original.setCashMargin((byte) 1);
    original.setCounterPartyPbuid("111111");
    original.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteExtend070 decoded = new QuoteExtend070();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
