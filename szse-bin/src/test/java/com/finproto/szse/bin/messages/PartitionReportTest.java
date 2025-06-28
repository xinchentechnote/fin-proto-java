package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class PartitionReportTest {
  @Test
  public void testEncodeDecode() {
    PartitionReport original = new PartitionReport();
    original.setPartitionNo(4);
    original.setReportIndex(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PartitionReport decoded = new PartitionReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
