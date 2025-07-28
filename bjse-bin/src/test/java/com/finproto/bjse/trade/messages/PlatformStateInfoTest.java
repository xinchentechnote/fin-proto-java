package com.finproto.bjse.trade.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class PlatformStateInfoTest {
  @Test
  public void testEncodeDecode() {
    PlatformStateInfo original = new PlatformStateInfo();
    original.setPlatformId((short) 2);
    original.setPlatformState((short) 2);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformStateInfo decoded = new PlatformStateInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
