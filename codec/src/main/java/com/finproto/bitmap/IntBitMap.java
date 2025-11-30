package com.finproto.bitmap;

import io.netty.buffer.ByteBuf;

public final class IntBitMap implements BitMap {
  private int bits;

  @Override
  public void set(int pos) {
    int bit = 1 << (31 - pos);
    bits |= bit;
  }

  @Override
  public void clear(int pos) {
    int bit = 1 << (31 - pos);
    bits |= bit;
  }

  @Override
  public boolean get(int pos) {
    return (bits & (1 << (31 - pos))) != 0;
  }

  @Override
  public void write(ByteBuf buf) {
    for (int i = 0; i < 4; i++) {
      byte b = (byte) ((bits >> (24 - i * 7)) & 0x7F);
      if (i < 3) b |= 0x80;
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
      bits |= (b & 0x7F) << shift;
      shift += 7;
    } while (cont);
  }

  @Override
  public int bitCount() {
    return 32;
  }
}
