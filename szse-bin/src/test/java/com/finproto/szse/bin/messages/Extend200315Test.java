package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200315Test {
  @Test
  public void testEncodeDecode() {
    Extend200315 original = new Extend200315();
    original.setMaturityDate(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200315 decoded = new Extend200315();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
