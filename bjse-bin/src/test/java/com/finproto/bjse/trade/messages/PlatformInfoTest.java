package com.finproto.bjse.trade.messages;

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
    PlatformInfo.NoPartitions noPartitions = new PlatformInfo.NoPartitions();
    noPartitions.setPartitionNo(4);
    noPartitions.setPartitionName("11111111111111111111");
    original.setNoPartitions(Arrays.asList(noPartitions));

    ByteBuf buffer = Unpooled.buffer();
    original.encode(buffer);
    PlatformInfo decoded = new PlatformInfo();
    decoded.decode(buffer);
    assertEquals(original, decoded);
  }
}
