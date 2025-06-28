package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend203102Test {
  @Test
  public void testEncodeDecode() {
    Extend203102 original = new Extend203102();
    original.setInsufficientSecurityId("11111111");
    original.setNoSecurity(4);
    original.setUnderlyingSecurityId("11111111");
    original.setUnderlyingSecurityIdsource("1111");
    original.setDeliveryQty(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend203102 decoded = new Extend203102();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
