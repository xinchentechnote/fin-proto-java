package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend201802Test {
  @Test
  public void testEncodeDecode() {
    Extend201802 original = new Extend201802();
    original.setTenderer("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend201802 decoded = new Extend201802();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
