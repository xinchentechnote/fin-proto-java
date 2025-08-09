package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureConfirmExtend060Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureConfirmExtend060 original = new TradeCaptureConfirmExtend060();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureConfirmExtend060 decoded = new TradeCaptureConfirmExtend060();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
