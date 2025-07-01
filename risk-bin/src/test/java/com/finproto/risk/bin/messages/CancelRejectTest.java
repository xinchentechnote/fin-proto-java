package com.finproto.risk.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class CancelRejectTest {
  @Test
  public void testEncodeDecode() {
    CancelReject original = new CancelReject();
    original.setClOrdId("example");
    original.setOrigClOrdId("example");
    original.setCxlRejReason(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    CancelReject decoded = new CancelReject();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
