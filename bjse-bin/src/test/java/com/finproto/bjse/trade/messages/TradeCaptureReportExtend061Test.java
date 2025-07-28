package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportExtend061Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportExtend061 original = new TradeCaptureReportExtend061();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportExtend061 decoded = new TradeCaptureReportExtend061();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
