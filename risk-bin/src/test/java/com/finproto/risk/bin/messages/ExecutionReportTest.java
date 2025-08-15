package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExecutionReportTest {
  @Test
  public void testEncodeDecode() {
    ExecutionReport original = new ExecutionReport();
    original.setUniqueOrderId("example");
    original.setClOrdId("example");
    original.setOrdCnfmId("example");
    original.setLastPx(8L);
    original.setLastQty(8L);
    original.setOrdStatus("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecutionReport decoded = new ExecutionReport();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
