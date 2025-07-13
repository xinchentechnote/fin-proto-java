package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend203702Test {
  @Test
  public void testEncodeDecode() {
    Extend203702 original = new Extend203702();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend203702 decoded = new Extend203702();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
