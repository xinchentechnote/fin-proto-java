package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ReportFinishedTest {
  @Test
  public void testEncodeDecode() {
    ReportFinished original = new ReportFinished();
    original.setPartitionNo(4);
    original.setReportIndex(8L);
    original.setPlatformId((short) 2);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportFinished decoded = new ReportFinished();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
