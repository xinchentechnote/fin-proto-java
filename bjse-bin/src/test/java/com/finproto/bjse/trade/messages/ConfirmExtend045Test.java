package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend045Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend045 original = new ConfirmExtend045();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend045 decoded = new ConfirmExtend045();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
