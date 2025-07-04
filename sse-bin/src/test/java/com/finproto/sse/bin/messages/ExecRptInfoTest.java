package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class ExecRptInfoTest {
  @Test
  public void testEncodeDecode() {
    ExecRptInfo original = new ExecRptInfo();
    original.setPlatformId((short) 2);
    original.setPbu(Arrays.asList("11111111"));
    original.setSetId(Arrays.asList(4));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecRptInfo decoded = new ExecRptInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
