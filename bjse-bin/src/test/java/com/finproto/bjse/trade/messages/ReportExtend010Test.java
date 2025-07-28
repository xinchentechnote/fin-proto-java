package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ReportExtend010Test {
  @Test
  public void testEncodeDecode() {
    ReportExtend010 original = new ReportExtend010();
    original.setCashMargin((byte) 1);
    original.setSettlType((byte) 1);
    original.setSettlPeriod((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportExtend010 decoded = new ReportExtend010();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
