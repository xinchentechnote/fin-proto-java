package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200702Test {
  @Test
  public void testEncodeDecode() {
    Extend200702 original = new Extend200702();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200702 decoded = new Extend200702();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
