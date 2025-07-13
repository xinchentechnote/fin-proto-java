package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200515Test {
  @Test
  public void testEncodeDecode() {
    Extend200515 original = new Extend200515();
    original.setConfirmId("11111111");
    original.setCashMargin("1");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200515 decoded = new Extend200515();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
