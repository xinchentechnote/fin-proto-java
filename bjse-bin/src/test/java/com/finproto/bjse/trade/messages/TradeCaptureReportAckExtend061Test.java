package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckExtend061Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAckExtend061 original = new TradeCaptureReportAckExtend061();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportAckExtend061 decoded = new TradeCaptureReportAckExtend061();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
