package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend050Test {
  @Test
  public void testEncodeDecode() {
    Extend050 original = new Extend050();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend050 decoded = new Extend050();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
