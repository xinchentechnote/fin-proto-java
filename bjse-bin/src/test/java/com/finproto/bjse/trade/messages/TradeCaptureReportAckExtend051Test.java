package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportAckExtend051Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportAckExtend051 original = new TradeCaptureReportAckExtend051();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportAckExtend051 decoded = new TradeCaptureReportAckExtend051();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
