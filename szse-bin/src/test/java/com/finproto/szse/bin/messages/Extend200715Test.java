package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200715Test {
  @Test
  public void testEncodeDecode() {
    Extend200715 original = new Extend200715();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setMaturityDate(4);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200715 decoded = new Extend200715();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
