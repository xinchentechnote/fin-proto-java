package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class OrderCancelRequestTest {
  @Test
  public void testEncodeDecode() {
    OrderCancelRequest original = new OrderCancelRequest();
    original.setApplId("111");
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111111111111111111111111111");
    original.setClOrdId("1111111111");
    original.setOrigClOrdId("1111111111");
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setOrderId("1111111111111111");
    original.setOrderQty(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    OrderCancelRequest decoded = new OrderCancelRequest();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
