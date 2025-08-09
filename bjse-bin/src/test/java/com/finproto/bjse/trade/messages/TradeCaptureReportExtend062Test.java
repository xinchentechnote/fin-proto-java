package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportExtend062Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportExtend062 original = new TradeCaptureReportExtend062();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportExtend062 decoded = new TradeCaptureReportExtend062();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
