package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportExtend060Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportExtend060 original = new TradeCaptureReportExtend060();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportExtend060 decoded = new TradeCaptureReportExtend060();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
