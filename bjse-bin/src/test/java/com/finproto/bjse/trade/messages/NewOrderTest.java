package com.finproto.bjse.trade.messages;

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
    original.setUserInfo("11111111111111111111111111111111");
    original.setClOrdId("1111111111");
    original.setAccountId("1111111111");
    original.setBranchId("11");
    original.setOrderRestrictions("1111");
    original.setSide("1");
    original.setOrdType("1");
    original.setOrderQty(8L);
    original.setPrice(8L);
    original.setApplId("010");
    ExtendNewOrder010 extendNewOrder010 = new ExtendNewOrder010();
    extendNewOrder010.setStopPx(8L);
    extendNewOrder010.setMinQty(8L);
    extendNewOrder010.setMaxPriceLevels((short) 2);
    extendNewOrder010.setTimeInForce("1");
    extendNewOrder010.setCashMargin("1");
    extendNewOrder010.setSettlType("1");
    extendNewOrder010.setSettlPeriod("1");
    original.setApplExtend(extendNewOrder010);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    NewOrder decoded = new NewOrder();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
