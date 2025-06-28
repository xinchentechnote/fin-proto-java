package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class RiskControlResponseTest {
  @Test
  public void testEncodeDecode() {
    RiskControlResponse original = new RiskControlResponse();
    original.setUniqueOrderId("example");
    original.setStatus(4);
    original.setMsg("example");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    RiskControlResponse decoded = new RiskControlResponse();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
