package com.finproto.sse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class LogonTest {
  @Test
  public void testEncodeDecode() {
    Logon original = new Logon();
    original.setSenderCompId("11111111111111111111111111111111");
    original.setTargetCompId("11111111111111111111111111111111");
    original.setHeartBtInt((short) 2);
    original.setPrtclVersion("11111111");
    original.setTradeDate(4);
    original.setQsize(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Logon decoded = new Logon();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
