package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend204702Test {
  @Test
  public void testEncodeDecode() {
    Extend204702 original = new Extend204702();
    original.setSecondaryOrderId("1111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend204702 decoded = new Extend204702();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
