package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckExtend060Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAckExtend060 original = new TradeCaptureReportAckExtend060();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportAckExtend060 decoded = new TradeCaptureReportAckExtend060();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
