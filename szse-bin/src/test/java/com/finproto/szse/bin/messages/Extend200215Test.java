package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200215Test {
  @Test
  public void testEncodeDecode() {
    Extend200215 original = new Extend200215();
    original.setMaturityDate(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200215 decoded = new Extend200215();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
