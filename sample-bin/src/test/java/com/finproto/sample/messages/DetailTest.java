package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class DetailTest {
  @Test
  public void testEncodeDecode() {
    Detail original = new Detail();
    original.setRuleName("example");
    original.setCode((short) 2);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    Detail decoded = new Detail();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
