package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder043Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder043 original = new ExtendNewOrder043();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder043 decoded = new ExtendNewOrder043();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
