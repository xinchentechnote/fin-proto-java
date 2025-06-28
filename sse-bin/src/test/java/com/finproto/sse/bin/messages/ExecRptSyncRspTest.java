package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExecRptSyncRspTest {
  @Test
  public void testEncodeDecode() {
    ExecRptSyncRsp original = new ExecRptSyncRsp();
    ExecRptSyncRsp.SubExecRptSyncRsp subExecRptSyncRsp = new ExecRptSyncRsp.SubExecRptSyncRsp();
    subExecRptSyncRsp.setPbu("11111111");
    subExecRptSyncRsp.setSetId(4);
    subExecRptSyncRsp.setBeginReportIndex(8L);
    subExecRptSyncRsp.setEndReportIndex(8L);
    subExecRptSyncRsp.setRejReason(4);
    subExecRptSyncRsp.setText("1111111111111111111111111111111111111111111111111111111111111111");
    original.setSubExecRptSyncRsp(subExecRptSyncRsp);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExecRptSyncRsp decoded = new ExecRptSyncRsp();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
