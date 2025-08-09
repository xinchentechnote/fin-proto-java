package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class ExtendNewOrder050Test {
  @Test
  public void testEncodeDecode() {
    ExtendNewOrder050 original = new ExtendNewOrder050();
    original.setExpirationDays((short) 2);
    original.setExpirationType((byte) 1);
    original.setShareProperty("11");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    ExtendNewOrder050 decoded = new ExtendNewOrder050();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
