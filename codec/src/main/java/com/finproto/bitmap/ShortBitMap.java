package com.finproto.bitmap;

import io.netty.buffer.ByteBuf;

public final class ShortBitMap implements BitMap {
  private short bits;

  @Override
  public void set(int pos) {
    int bit = 1 << (15 - pos);
    bits |= bit;
  }

  @Override
  public void clear(int pos) {
    int bit = 1 << (15 - pos);
    bits &= ~bit;
  }

  @Override
  public boolean get(int pos) {
    return (bits & (1 << (15 - pos))) != 0;
  }

  @Override
  public void write(ByteBuf buf) {
    byte high = (byte) ((bits >> 8) & 0xFF);
    byte low = (byte) (bits & 0xFF);
    high |= 0x80;
    buf.writeByte(high);
    buf.writeByte(low);
  }

  @Override
  public void read(ByteBuf buf) {
    byte b1 = buf.readByte();
    byte b2 = buf.readByte();
    bits = (short) (((b1 & 0x7F) << 8) | (b2 & 0x7F));
  }

  @Override
  public int bitCount() {
    return 16;
  }
}
