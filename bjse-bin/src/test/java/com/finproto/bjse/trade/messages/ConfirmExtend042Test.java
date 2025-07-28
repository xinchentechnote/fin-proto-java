package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend042Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend042 original = new ConfirmExtend042();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend042 decoded = new ConfirmExtend042();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
