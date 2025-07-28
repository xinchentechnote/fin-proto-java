package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class QuoteExtend071Test {
  @Test
  public void testEncodeDecode() {
    QuoteExtend071 original = new QuoteExtend071();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    QuoteExtend071 decoded = new QuoteExtend071();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
