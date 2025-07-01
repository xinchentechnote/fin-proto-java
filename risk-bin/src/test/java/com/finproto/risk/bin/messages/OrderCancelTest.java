package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class OrderCancelTest {
  @Test
  public void testEncodeDecode() {
    OrderCancel original = new OrderCancel();
    original.setClOrdId("example");
    original.setOrigClOrdId("example");
    original.setSecurityId("example");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    OrderCancel decoded = new OrderCancel();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
