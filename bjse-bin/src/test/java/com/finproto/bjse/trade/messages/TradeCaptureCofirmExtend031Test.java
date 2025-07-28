package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class TradeCaptureCofirmExtend031Test {
  @Test
  public void testEncodeDecode() {
    TradeCaptureCofirmExtend031 original = new TradeCaptureCofirmExtend031();
    original.setMemberId("111111");
    original.setTraderCode("11111");
    original.setCounterPartyMemberId("111111");
    original.setCounterPartyTraderCode("11111");
    original.setSettlType((byte) 1);
    original.setSettlPeriod((byte) 1);
    original.setCashMargin((byte) 1);
    original.setMemo(
        "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    TradeCaptureCofirmExtend031 decoded = new TradeCaptureCofirmExtend031();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
