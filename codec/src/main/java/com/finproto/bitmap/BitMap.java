package com.finproto.bitmap;

import io.netty.buffer.ByteBuf;

public interface BitMap {
  void set(int pos);

  boolean get(int pos);

  void clear(int pos);

  void write(ByteBuf buf);

  void read(ByteBuf buf);

  int bitCount();
}
