package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend202802Test {
  @Test
  public void testEncodeDecode() {
    Extend202802 original = new Extend202802();
    original.setLenderPbu("111111");
    original.setLenderAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend202802 decoded = new Extend202802();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
