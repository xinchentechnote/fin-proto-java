package com.finproto.szse.bin.messages;

import static org.junit.Assert.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import org.junit.Test;

public class PlatformInfoTest {
  @Test
  public void testEncodeDecode() {
    PlatformInfo original = new PlatformInfo();
    original.setPlatformId((short) 2);
    PlatformPartition platformPartition0 = new PlatformPartition();
    platformPartition0.setPartitionNo(4);
    original.setPlatformPartition(Arrays.asList(platformPartition0));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformInfo decoded = new PlatformInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
