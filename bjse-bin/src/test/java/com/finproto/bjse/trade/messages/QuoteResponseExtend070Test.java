package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class QuoteResponseExtend070Test {
  @Test
  public void testEncodeDecode() {
    QuoteResponseExtend070 original = new QuoteResponseExtend070();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteResponseExtend070 decoded = new QuoteResponseExtend070();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
