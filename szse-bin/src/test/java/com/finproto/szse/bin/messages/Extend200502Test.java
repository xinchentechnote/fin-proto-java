package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200502Test {
  @Test
  public void testEncodeDecode() {
    Extend200502 original = new Extend200502();
    original.setConfirmId("11111111");
    original.setCashMargin((byte) 1);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200502 decoded = new Extend200502();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
