package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class NewOrderSingleTest {
  @Test
  public void testEncodeDecode() {
    NewOrderSingle original = new NewOrderSingle();
    original.setBizId(4);
    original.setBizPbu("11111111");
    original.setClOrdId("1111111111");
    original.setSecurityId("111111111111");
    original.setAccount("1111111111111");
    original.setOwnerType((byte) 1);
    original.setSide("1");
    original.setPrice(8L);
    original.setOrderQty(8L);
    original.setOrdType("1");
    original.setTimeInForce("1");
    original.setTransactTime(8L);
    original.setCreditTag("11");
    original.setClearingFirm("11111111");
    original.setBranchId("11111111");
    original.setUserInfo("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    NewOrderSingle decoded = new NewOrderSingle();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
