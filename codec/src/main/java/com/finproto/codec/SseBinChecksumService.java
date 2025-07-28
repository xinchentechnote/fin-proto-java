package com.finproto.codec;

import io.netty.buffer.ByteBuf;

/**
 * uint32 CalcChecksum(const char* buffer, uint32 len) { uint8 checksum = 0; uint32 i = 0; for (i =
 * 0; i < len; i++) { checksum += (uint8)buffer[i]; } return (uint32)checksum; }
 */
public class SseBinChecksumService implements ChecksumService<ByteBuf, Integer> {

  @Override
  public Integer calc(ByteBuf buf) {
    int readerIndex = buf.readerIndex();
    int readableBytes = buf.readableBytes();
    int checksum = 0;
    for (int i = 0; i < readableBytes; i++) {
      int b = buf.getUnsignedByte(readerIndex + i);
      checksum = (checksum + b) & 0xFF;
    }

    return checksum;
  }

  @Override
  public String algorithm() {
    return ChecksumAlgorithms.SSE_BIN;
  }
}
