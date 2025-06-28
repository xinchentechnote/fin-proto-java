package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class PlatformStateTest {
  @Test
  public void testEncodeDecode() {
    PlatformState original = new PlatformState();
    original.setPlatformId((short) 2);
    original.setPlatformState((short) 2);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformState decoded = new PlatformState();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
