package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class PlatformPartitionTest {
  @Test
  public void testEncodeDecode() {
    PlatformPartition original = new PlatformPartition();
    original.setPartitionNo(4);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformPartition decoded = new PlatformPartition();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
