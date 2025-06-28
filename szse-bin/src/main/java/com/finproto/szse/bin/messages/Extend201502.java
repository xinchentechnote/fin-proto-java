package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend201502 implements BinaryCodec {
  private String shareProperty;

  public String getShareProperty() {
    return this.shareProperty;
  }

  public void setShareProperty(String shareProperty) {
    this.shareProperty = shareProperty;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.shareProperty, 2);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.shareProperty = readFixedString(byteBuf, 2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shareProperty);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend201502 orther_ = (Extend201502) obj;
    return Objects.equals(shareProperty, orther_.shareProperty);
  }

  @Override
  public String toString() {
    return "Extend201502 [" + "shareProperty=" + this.shareProperty + "]";
  }
}
