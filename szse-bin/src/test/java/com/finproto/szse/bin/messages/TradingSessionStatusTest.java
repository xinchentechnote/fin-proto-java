package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradingSessionStatusTest {
  @Test
  public void testEncodeDecode() {
    TradingSessionStatus original = new TradingSessionStatus();
    original.setMarketId("11111111");
    original.setMarketSegmentId("11111111");
    original.setTradingSessionId("1111");
    original.setTradingSessionSubId("1111");
    original.setTradSesStatus((short) 2);
    original.setTradSesStartTime(8L);
    original.setTradSesEndTime(8L);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradingSessionStatus decoded = new TradingSessionStatus();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
