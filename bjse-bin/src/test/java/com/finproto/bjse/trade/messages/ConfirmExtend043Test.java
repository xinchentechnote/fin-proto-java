package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend043Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend043 original = new ConfirmExtend043();

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend043 decoded = new ConfirmExtend043();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
