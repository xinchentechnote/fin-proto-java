package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend043Test {
  @Test
  public void testEncodeDecode() {
    Extend043 original = new Extend043();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend043 decoded = new Extend043();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
