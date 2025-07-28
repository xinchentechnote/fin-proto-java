package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ReportExtend050Test {
  @Test
  public void testEncodeDecode() {
    ReportExtend050 original = new ReportExtend050();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setMaturityDate(4);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportExtend050 decoded = new ReportExtend050();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
