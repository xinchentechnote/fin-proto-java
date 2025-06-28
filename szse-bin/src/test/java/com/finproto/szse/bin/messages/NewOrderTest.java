package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class NewOrderTest {
  @Test
  public void testEncodeDecode() {
    NewOrder original = new NewOrder();
    original.setSubmittingPbuid("111111");
    original.setSecurityId("11111111");
    original.setSecurityIdsource("1111");
    original.setOwnerType((short) 2);
    original.setClearingFirm("11");
    original.setTransactTime(8L);
    original.setUserInfo("11111111");
    original.setClOrdId("1111111111");
    original.setAccountId("111111111111");
    original.setBranchId("1111");
    original.setOrderRestrictions("1111");
    original.setSide((byte) 1);
    original.setOrdType((byte) 1);
    original.setOrderQty(8L);
    original.setPrice(8L);
    original.setApplId("010");
    Extend100101 extend100101 = new Extend100101();
    extend100101.setStopPx(8L);
    extend100101.setMinQty(8L);
    extend100101.setMaxPriceLevels((short) 2);
    extend100101.setTimeInForce((byte) 1);
    extend100101.setCashMargin((byte) 1);
    original.setApplExtend(extend100101);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    NewOrder decoded = new NewOrder();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
