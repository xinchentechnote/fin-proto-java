package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend101501Test {
  @Test
  public void testEncodeDecode() {
    Extend101501 original = new Extend101501();
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend101501 decoded = new Extend101501();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
