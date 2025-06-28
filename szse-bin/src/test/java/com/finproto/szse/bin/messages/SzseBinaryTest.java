package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class SzseBinaryTest {
  @Test
  public void testEncodeDecode() {
    SzseBinary original = new SzseBinary();
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
    SzseBinary decoded = new SzseBinary();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
