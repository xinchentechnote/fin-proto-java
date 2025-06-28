package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend104701Test {
  @Test
  public void testEncodeDecode() {
    Extend104701 original = new Extend104701();
    original.setSecondaryOrderId("1111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend104701 decoded = new Extend104701();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
