package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend201702Test {
  @Test
  public void testEncodeDecode() {
    Extend201702 original = new Extend201702();
    original.setCashOrderQty(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend201702 decoded = new Extend201702();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
