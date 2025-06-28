package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend102901Test {
  @Test
  public void testEncodeDecode() {
    Extend102901 original = new Extend102901();
    original.setDeductionPbu("111111");
    original.setDeductionAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend102901 decoded = new Extend102901();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
