package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend201502Test {
  @Test
  public void testEncodeDecode() {
    Extend201502 original = new Extend201502();
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend201502 decoded = new Extend201502();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
