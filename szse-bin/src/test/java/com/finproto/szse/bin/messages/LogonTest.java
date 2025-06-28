package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class LogonTest {
  @Test
  public void testEncodeDecode() {
    Logon original = new Logon();
    original.setSenderCompId("11111111111111111111");
    original.setTargetCompId("11111111111111111111");
    original.setHeartBtInt(4);
    original.setPassword("1111111111111111");
    original.setDefaultApplVerId("11111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Logon decoded = new Logon();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
