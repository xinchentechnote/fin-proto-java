package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckExtend062Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAckExtend062 original = new TradeCaptureReportAckExtend062();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportAckExtend062 decoded = new TradeCaptureReportAckExtend062();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
