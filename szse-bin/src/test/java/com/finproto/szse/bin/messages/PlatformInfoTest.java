package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class PlatformInfoTest {
  @Test
  public void testEncodeDecode() {
    PlatformInfo original = new PlatformInfo();
    original.setPlatformId((short) 2);
    original.setNoPartitions(4);
    PlatformPartition platformPartition = new PlatformPartition();
    platformPartition.setPartitionNo(4);
    original.setPlatformPartition(platformPartition);

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformInfo decoded = new PlatformInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
