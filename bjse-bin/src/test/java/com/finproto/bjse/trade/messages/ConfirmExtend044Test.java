package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend044Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend044 original = new ConfirmExtend044();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend044 decoded = new ConfirmExtend044();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
