package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ReportExtend040Test {
  @Test
  public void testEncodeDecode() {
    ReportExtend040 original = new ReportExtend040();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportExtend040 decoded = new ReportExtend040();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
