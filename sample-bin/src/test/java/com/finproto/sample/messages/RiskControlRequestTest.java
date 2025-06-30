package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class RiskControlRequestTest {
  @Test
  public void testEncodeDecode() {
    RiskControlRequest original = new RiskControlRequest();
    original.setUniqueOrderId("example");
    original.setClOrdId("1111111111111111");
    original.setMarketId("111");
    original.setSecurityId("111111111111");
    original.setSide((byte) 1);
    original.setOrderType((byte) 1);
    original.setPrice(8L);
    original.setQty(4);
    original.setExtraInfo(Arrays.asList("example"));
    RiskControlRequest.SubOrder subOrder = new RiskControlRequest.SubOrder();
    subOrder.setClOrdId("1111111111111111");
    subOrder.setPrice(8L);
    subOrder.setQty(4);
    original.setSubOrder(subOrder);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    RiskControlRequest decoded = new RiskControlRequest();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
