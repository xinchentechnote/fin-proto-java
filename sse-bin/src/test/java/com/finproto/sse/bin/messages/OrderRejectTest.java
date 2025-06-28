package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class OrderRejectTest {
  @Test
  public void testEncodeDecode() {
    OrderReject original = new OrderReject();
    original.setBizId(4);
    original.setBizPbu("11111111");
    original.setClOrdId("1111111111");
    original.setSecurityId("111111111111");
    original.setOrdRejReason(4);
    original.setTradeDate(4);
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    OrderReject decoded = new OrderReject();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
