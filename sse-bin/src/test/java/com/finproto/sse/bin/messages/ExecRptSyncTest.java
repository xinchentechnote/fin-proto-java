package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class ExecRptSyncTest {
  @Test
  public void testEncodeDecode() {
    ExecRptSync original = new ExecRptSync();
    ExecRptSync.SubExecRptSync subExecRptSync = new ExecRptSync.SubExecRptSync();
    subExecRptSync.setPbu("11111111");
    subExecRptSync.setSetId(4);
    subExecRptSync.setBeginReportIndex(8L);
    original.setSubExecRptSync(Arrays.asList(subExecRptSync));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecRptSync decoded = new ExecRptSync();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
