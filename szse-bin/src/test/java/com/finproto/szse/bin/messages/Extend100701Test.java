package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend100701Test {
  @Test
  public void testEncodeDecode() {
    Extend100701 original = new Extend100701();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend100701 decoded = new Extend100701();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
