package com.finproto.codec;

import io.netty.buffer.ByteBuf;

/** CRC-32/ISO-HDLC */
public class Crc32ChecksumService implements ChecksumService<ByteBuf, Integer> {

  private static final int[] CRC_TABLE = new int[256];

  static {
    for (int i = 0; i < 256; i++) {
      int c = i;
      for (int j = 0; j < 8; j++) {
        if ((c & 1) != 0) {
          c = 0xEDB88320 ^ (c >>> 1);
        } else {
          c >>>= 1;
        }
      }
      CRC_TABLE[i] = c;
    }
  }

  @Override
  public Integer calc(ByteBuf buf) {
    int crc = 0xFFFFFFFF;
    int readerIndex = buf.readerIndex();
    int readableBytes = buf.readableBytes();

    for (int i = 0; i < readableBytes; i++) {
      int b = buf.getUnsignedByte(readerIndex + i);
      crc = CRC_TABLE[(crc ^ b) & 0xFF] ^ (crc >>> 8);
    }

    return crc ^ 0xFFFFFFFF;
  }

  @Override
  public String algorithm() {
    return ChecksumAlgorithms.CRC32;
  }
}
