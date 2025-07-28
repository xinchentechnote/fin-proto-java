package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureCofirmExtend061Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureCofirmExtend061 original = new TradeCaptureCofirmExtend061();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureCofirmExtend061 decoded = new TradeCaptureCofirmExtend061();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
