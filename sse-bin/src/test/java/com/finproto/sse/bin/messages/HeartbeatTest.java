package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class HeartbeatTest {
  @Test
  public void testEncodeDecode() {
    Heartbeat original = new Heartbeat();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Heartbeat decoded = new Heartbeat();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
