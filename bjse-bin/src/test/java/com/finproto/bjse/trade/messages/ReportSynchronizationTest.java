package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class ReportSynchronizationTest {
  @Test
  public void testEncodeDecode() {
    ReportSynchronization original = new ReportSynchronization();
    ReportSynchronization.ReportPartitionSync reportPartitionSync =
        new ReportSynchronization.ReportPartitionSync();
    reportPartitionSync.setPartitionNo(4);
    reportPartitionSync.setReportIndex(8L);
    original.setReportPartitionSync(Arrays.asList(reportPartitionSync));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportSynchronization decoded = new ReportSynchronization();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
