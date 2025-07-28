package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ConfirmExtend050Test {
  @Test
  public void testEncodeDecode() {
    ConfirmExtend050 original = new ConfirmExtend050();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ConfirmExtend050 decoded = new ConfirmExtend050();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
