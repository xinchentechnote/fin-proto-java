package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend102701Test {
  @Test
  public void testEncodeDecode() {
    Extend102701 original = new Extend102701();
    original.setDisposalPbu("111111");
    original.setDisposalAccountId("111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend102701 decoded = new Extend102701();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
