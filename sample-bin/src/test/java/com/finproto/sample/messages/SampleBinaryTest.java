package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class SampleBinaryTest {
  @Test
  public void testEncodeDecode() {
    SampleBinary original = new SampleBinary();
    original.setMsgType((short) 4);
    RiskControlRequest riskControlRequest = new RiskControlRequest();
    riskControlRequest.setUniqueOrderId("example");
    riskControlRequest.setClOrdId("1111111111111111");
    riskControlRequest.setMarketId("111");
    riskControlRequest.setSecurityId("111111111111");
    riskControlRequest.setSide((byte) 1);
    riskControlRequest.setOrderType((byte) 1);
    riskControlRequest.setPrice(8L);
    riskControlRequest.setQty(4);
    riskControlRequest.setExtraInfo("example");
    RiskControlRequest.SubOrder subOrder = new RiskControlRequest.SubOrder();
    subOrder.setClOrdId("1111111111111111");
    subOrder.setPrice(8L);
    subOrder.setQty(4);
    riskControlRequest.setSubOrder(subOrder);
    original.setBody(riskControlRequest);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    SampleBinary decoded = new SampleBinary();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
