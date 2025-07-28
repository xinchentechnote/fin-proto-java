package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureCofirmExtend060Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureCofirmExtend060 original = new TradeCaptureCofirmExtend060();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureCofirmExtend060 decoded = new TradeCaptureCofirmExtend060();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
