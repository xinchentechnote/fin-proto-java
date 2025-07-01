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
    PartitionReport partitionReport0 = new PartitionReport();
    partitionReport0.setPartitionNo(4);
    partitionReport0.setReportIndex(8L);
    original.setPartitionReport(Arrays.asList(partitionReport0));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ReportSynchronization decoded = new ReportSynchronization();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
