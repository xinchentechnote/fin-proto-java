package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend100501Test {
  @Test
  public void testEncodeDecode() {
    Extend100501 original = new Extend100501();
    original.setConfirmId("11111111");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend100501 decoded = new Extend100501();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
