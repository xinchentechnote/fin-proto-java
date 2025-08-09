package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureConfirmExtend051Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureConfirmExtend051 original = new TradeCaptureConfirmExtend051();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setMaturityDate(4);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureConfirmExtend051 decoded = new TradeCaptureConfirmExtend051();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
