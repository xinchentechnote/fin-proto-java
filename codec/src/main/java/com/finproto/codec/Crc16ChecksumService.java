package com.finproto.codec;

import io.netty.buffer.ByteBuf;

/** CRC-16/MODBUS */
public class Crc16ChecksumService implements ChecksumService<ByteBuf, Integer> {

  private static final int[] CRC_TABLE = new int[256];

  static {
    for (int i = 0; i < 256; i++) {
      int crc = i;
      for (int j = 0; j < 8; j++) {
        if ((crc & 1) != 0) {
          crc = (crc >>> 1) ^ 0xA001;
        } else {
          crc >>>= 1;
        }
      }
      CRC_TABLE[i] = crc;
    }
  }

  @Override
  public Integer calc(ByteBuf buf) {
    int crc = 0xFFFF;
    int readerIndex = buf.readerIndex();
    int readableBytes = buf.readableBytes();

    for (int i = 0; i < readableBytes; i++) {
      int b = buf.getUnsignedByte(readerIndex + i);
      crc = (crc >>> 8) ^ CRC_TABLE[(crc ^ b) & 0xFF];
    }

    return crc & 0xFFFF;
  }

  @Override
  public String algorithm() {
    return ChecksumAlgorithms.CRC16;
  }
}
