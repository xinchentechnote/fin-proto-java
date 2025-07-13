package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class RcBinaryTest {
  @Test
  public void testEncodeDecode() {
    RcBinary original = new RcBinary();
    original.setVersion(4);
    original.setMsgType((int) 100101);
    NewOrder newOrder = new NewOrder();
    newOrder.setClOrdId("example");
    newOrder.setSecurityId("example");
    newOrder.setSide("1");
    newOrder.setPrice(8L);
    newOrder.setOrderQty(8L);
    newOrder.setOrdType("1");
    newOrder.setAccount("example");
    original.setBody(newOrder);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    RcBinary decoded = new RcBinary();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
