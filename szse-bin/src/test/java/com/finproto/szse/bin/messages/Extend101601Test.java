package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend101601Test {
  @Test
  public void testEncodeDecode() {
    Extend101601 original = new Extend101601();
    original.setContractAccountCode("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend101601 decoded = new Extend101601();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
