package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend103501Test {
  @Test
  public void testEncodeDecode() {
    Extend103501 original = new Extend103501();
    original.setContractAccountCode("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend103501 decoded = new Extend103501();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
