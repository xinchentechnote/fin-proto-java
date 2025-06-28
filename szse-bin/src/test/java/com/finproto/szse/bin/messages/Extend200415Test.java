package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend200415Test {
  @Test
  public void testEncodeDecode() {
    Extend200415 original = new Extend200415();
    original.setPositionEffect((byte) 1);
    original.setCoveredOrUncovered((byte) 1);
    original.setContractAccountCode("111111");
    original.setSecondaryOrderId("1111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend200415 decoded = new Extend200415();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
