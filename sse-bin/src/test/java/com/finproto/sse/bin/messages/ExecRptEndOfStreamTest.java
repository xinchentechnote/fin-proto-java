package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExecRptEndOfStreamTest {
  @Test
  public void testEncodeDecode() {
    ExecRptEndOfStream original = new ExecRptEndOfStream();
    original.setPbu("11111111");
    original.setSetId(4);
    original.setEndReportIndex(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecRptEndOfStream decoded = new ExecRptEndOfStream();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
