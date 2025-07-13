package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend100601Test {
  @Test
  public void testEncodeDecode() {
    Extend100601 original = new Extend100601();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend100601 decoded = new Extend100601();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
