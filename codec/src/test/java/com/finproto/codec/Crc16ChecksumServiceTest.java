package com.finproto.codec;

import static org.junit.Assert.assertEquals;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

public class Crc16ChecksumServiceTest {
  @Test
  public void testCalc() {
    ByteBuf buf = Unpooled.wrappedBuffer("123456789".getBytes());
    ChecksumService<ByteBuf, Integer> service = new Crc16ChecksumService();
    int checksum = service.calc(buf);

    assertEquals(0x4B37, checksum);
  }
}
