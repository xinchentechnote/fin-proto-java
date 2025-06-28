package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend201202Test {
  @Test
  public void testEncodeDecode() {
    Extend201202 original = new Extend201202();
    original.setInsufficientSecurityId("11111111");
    original.setNoSecurity(4);
    original.setUnderlyingSecurityId("11111111");
    original.setUnderlyingSecurityIdsource("1111");
    original.setDeliveryQty(8L);
    original.setSubstCash(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend201202 decoded = new Extend201202();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
