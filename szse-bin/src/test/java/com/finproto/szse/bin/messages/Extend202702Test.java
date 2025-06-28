package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend202702Test {
  @Test
  public void testEncodeDecode() {
    Extend202702 original = new Extend202702();
    original.setDisposalPbu("111111");
    original.setDisposalAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend202702 decoded = new Extend202702();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
