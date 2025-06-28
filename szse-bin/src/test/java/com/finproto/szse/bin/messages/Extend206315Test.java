package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend206315Test {
  @Test
  public void testEncodeDecode() {
    Extend206315 original = new Extend206315();
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend206315 decoded = new Extend206315();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
