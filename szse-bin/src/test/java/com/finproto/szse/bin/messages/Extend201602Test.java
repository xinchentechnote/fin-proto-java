package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend201602Test {
  @Test
  public void testEncodeDecode() {
    Extend201602 original = new Extend201602();
    original.setContractAccountCode("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend201602 decoded = new Extend201602();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
