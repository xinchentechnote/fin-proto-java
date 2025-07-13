package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class NewOrderTest {
  @Test
  public void testEncodeDecode() {
    NewOrder original = new NewOrder();
    original.setClOrdId("example");
    original.setSecurityId("example");
    original.setSide("1");
    original.setPrice(8L);
    original.setOrderQty(8L);
    original.setOrdType("1");
    original.setAccount("example");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    NewOrder decoded = new NewOrder();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
