package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class OrderCancelTest {
  @Test
  public void testEncodeDecode() {
    OrderCancel original = new OrderCancel();
    original.setBizId(4);
    original.setBizPbu("11111111");
    original.setClOrdId("1111111111");
    original.setSecurityId("111111111111");
    original.setAccount("1111111111111");
    original.setOwnerType((byte) 1);
    original.setSide("1");
    original.setOrigClOrdId("1111111111");
    original.setTransactTime(8L);
    original.setBranchId("11111111");
    original.setUserInfo("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    OrderCancel decoded = new OrderCancel();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
