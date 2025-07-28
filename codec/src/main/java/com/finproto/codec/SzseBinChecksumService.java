package com.finproto.codec;

import io.netty.buffer.ByteBuf;

/**
 * uint32 GenerateCheckSum( char *buf, uint32 bufLen ) { long idx; uint32 cks; for( idx = 0L, cks =
 * 0; idx < bufLen; cks += (uint32)buf[ idx++ ] ); return （cks % 256 ); }
 */
public class SzseBinChecksumService implements ChecksumService<ByteBuf, Integer> {

  @Override
  public Integer calc(ByteBuf buf) {
    int readerIndex = buf.readerIndex();
    int readableBytes = buf.readableBytes();

    long sum = 0;
    for (int i = 0; i < readableBytes; i++) {
      sum += buf.getUnsignedByte(readerIndex + i);
    }

    return (int) (sum % 256);
  }

  @Override
  public String algorithm() {
    return ChecksumAlgorithms.SZSE_BIN;
  }
}
