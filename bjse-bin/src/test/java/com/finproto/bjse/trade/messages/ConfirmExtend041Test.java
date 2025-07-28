package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend041Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend041 original = new ConfirmExtend041();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend041 decoded = new ConfirmExtend041();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
