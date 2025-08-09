package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureConfirmExtend062Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureConfirmExtend062 original = new TradeCaptureConfirmExtend062();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureConfirmExtend062 decoded = new TradeCaptureConfirmExtend062();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
