package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureReportExtend051Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureReportExtend051 original = new TradeCaptureReportExtend051();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureReportExtend051 decoded = new TradeCaptureReportExtend051();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
