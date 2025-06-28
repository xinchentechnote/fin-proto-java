package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend202902Test {
  @Test
  public void testEncodeDecode() {
    Extend202902 original = new Extend202902();
    original.setDeductionPbu("111111");
    original.setDeductionAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend202902 decoded = new Extend202902();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
