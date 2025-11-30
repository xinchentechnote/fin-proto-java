package com.finproto.bitmap;

import io.netty.buffer.ByteBuf;

public final class ByteBitMap implements BitMap {
  private byte bits;

  @Override
  public void set(int pos) {
    int bit = 1 << (7 - pos);
    bits |= bit;
  }

  @Override
  public void clear(int pos) {
    int bit = 1 << (7 - pos);
    bits &= ~bit;
  }

  @Override
  public boolean get(int pos) {
    return (bits & (1 << (7 - pos))) != 0;
  }

  @Override
  public void write(ByteBuf buf) {
    buf.writeByte(bits);
  }

  @Override
  public void read(ByteBuf buf) {
    bits = buf.readByte();
  }

  @Override
  public int bitCount() {
    return 8;
  }
}
