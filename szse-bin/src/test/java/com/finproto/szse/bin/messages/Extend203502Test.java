package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Extend203502Test {
  @Test
  public void testEncodeDecode() {
    Extend203502 original = new Extend203502();
    original.setContractAccountCode("111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Extend203502 decoded = new Extend203502();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
