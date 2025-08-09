package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureConfirmExtend061Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureConfirmExtend061 original = new TradeCaptureConfirmExtend061();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureConfirmExtend061 decoded = new TradeCaptureConfirmExtend061();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
