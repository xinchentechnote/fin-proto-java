package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradingSessionStatusTest {
  @Test
  public void testEncodeDecode() {
    TradingSessionStatus original = new TradingSessionStatus();
    original.setMarketId("111");
    original.setMarketSegmentId("111");
    original.setTradingSessionId("111");
    original.setTradingSessionSubId("111");
    original.setTradSesStatus((byte) 1);
    original.setTradSesStartTime(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradingSessionStatus decoded = new TradingSessionStatus();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
