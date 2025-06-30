package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class ReportSynchronizationTest {
  @Test
  public void testEncodeDecode() {
    ReportSynchronization original = new ReportSynchronization();
    PartitionReport partitionReport = new PartitionReport();
    partitionReport.setPartitionNo(4);
    partitionReport.setReportIndex(8L);
    original.setPartitionReport(Arrays.asList(partitionReport));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportSynchronization decoded = new ReportSynchronization();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
