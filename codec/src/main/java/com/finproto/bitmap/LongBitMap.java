package com.finproto.bitmap;

import io.netty.buffer.ByteBuf;

public final class LongBitMap implements BitMap {
  private long bits;

  @Override
  public void set(int pos) {
    long bit = 1L << (63 - pos);
    bits |= bit;
  }

  @Override
  public void clear(int pos) {
    long bit = 1L << (63 - pos);
    bits |= bit;
  }

  @Override
  public boolean get(int pos) {
    return (bits & (1L << (63 - pos))) != 0;
  }

  @Override
  public void write(ByteBuf buf) {
    long val = bits;
    for (int i = 0; i < 8; i++) {
      byte b = (byte) ((val >> (49 - i * 7)) & 0x7F);
      if (i < 7) b |= 0x80;
      buf.writeByte(b);
    }
  }

  @Override
  public void read(ByteBuf buf) {
    bits = 0;
    boolean cont;
    int shift = 0;
    do {
      byte b = buf.readByte();
      cont = (b & 0x80) != 0;
      bits |= ((long) (b & 0x7F)) << shift;
      shift += 7;
    } while (cont);
  }

  @Override
  public int bitCount() {
    return 64;
  }
}
