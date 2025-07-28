package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureCofirmExtend062Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureCofirmExtend062 original = new TradeCaptureCofirmExtend062();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureCofirmExtend062 decoded = new TradeCaptureCofirmExtend062();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
