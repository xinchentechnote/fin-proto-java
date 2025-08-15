package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class OrderConfirmTest {
  @Test
  public void testEncodeDecode() {
    OrderConfirm original = new OrderConfirm();
    original.setUniqueOrderId("example");
    original.setUniqueOrigOrderId("example");
    original.setClOrdId("example");
    original.setExecType("1");
    original.setOrdRejReason(4);
    original.setOrdCnfmId("example");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    OrderConfirm decoded = new OrderConfirm();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
