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
    PlatformPartition platformPartition = new PlatformPartition();
    platformPartition.setPartitionNo(4);
    original.setPlatformPartition(Arrays.asList(platformPartition));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformInfo decoded = new PlatformInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
