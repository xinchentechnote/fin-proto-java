package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class AllegeQuoteExtend070Test {
  @Test
  public void testEncodeDecode() {
    AllegeQuoteExtend070 original = new AllegeQuoteExtend070();
    original.setCashMargin((byte) 1);
    original.setCounterPartyPbuid("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    AllegeQuoteExtend070 decoded = new AllegeQuoteExtend070();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
