package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class SseBinaryTest {
  @Test
  public void testEncodeDecode() {
    SseBinary original = new SseBinary();
    original.setMsgSeqNum(8L);
    original.setMsgType((int) 33);
    Heartbeat heartbeat = new Heartbeat();
    original.setBody(heartbeat);
    original.setChecksum(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    SseBinary decoded = new SseBinary();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
