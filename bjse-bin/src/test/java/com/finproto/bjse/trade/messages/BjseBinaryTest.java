package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class BjseBinaryTest {
  @Test
  public void testEncodeDecode() {
    BjseBinary original = new BjseBinary();
    original.setMsgType((int) 1);
    Logon logon = new Logon();
    logon.setSenderCompId("11111111111111111111");
    logon.setTargetCompId("11111111111111111111");
    logon.setHeartBtInt(4);
    logon.setPassword("1111111111111111");
    logon.setDefaultApplVerId("11111111111111111111111111111111");
    original.setBody(logon);
    original.setChecksum(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    BjseBinary decoded = new BjseBinary();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
