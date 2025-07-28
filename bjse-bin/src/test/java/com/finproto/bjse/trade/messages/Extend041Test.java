package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend041Test {
  @Test
  public void testEncodeDecode() {
    Extend041 original = new Extend041();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend041 decoded = new Extend041();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
