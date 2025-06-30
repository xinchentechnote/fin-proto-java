package com.finproto.sample.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class StringPacketTest {
  @Test
  public void testEncodeDecode() {
    StringPacket original = new StringPacket();
    original.setFieldDynamicString("example");
    original.setFieldDynamicString1("example");
    original.setFieldFixedString1("1");
    original.setFieldFixedString10("1111111111");
    original.setFieldDynamicStringList(Arrays.asList("example"));
    original.setFieldDynamicString1List(Arrays.asList("example"));
    original.setFieldFixedString1List(Arrays.asList("1"));
    original.setFieldFixedString10List(Arrays.asList("1111111111"));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    StringPacket decoded = new StringPacket();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
