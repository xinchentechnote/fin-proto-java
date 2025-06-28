package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend102801Test {
  @Test
  public void testEncodeDecode() {
    Extend102801 original = new Extend102801();
    original.setLenderPbu("111111");
    original.setLenderAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend102801 decoded = new Extend102801();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
