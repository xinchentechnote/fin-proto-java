package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend203715Test {
  @Test
  public void testEncodeDecode() {
    Extend203715 original = new Extend203715();
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend203715 decoded = new Extend203715();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
