package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class LogoutTest {
  @Test
  public void testEncodeDecode() {
    Logout original = new Logout();
    original.setSessionStatus(4);
    original.setText(
        "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Logout decoded = new Logout();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
