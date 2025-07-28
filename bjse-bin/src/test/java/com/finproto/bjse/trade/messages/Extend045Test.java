package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend045Test {
  @Test
  public void testEncodeDecode() {
    Extend045 original = new Extend045();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend045 decoded = new Extend045();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
