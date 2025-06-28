package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend101801 implements BinaryCodec {
  private String tenderer;

  public String getTenderer() {
    return this.tenderer;
  }

  public void setTenderer(String tenderer) {
    this.tenderer = tenderer;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.tenderer, 6);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.tenderer = readFixedString(byteBuf, 6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenderer);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend101801 orther_ = (Extend101801) obj;
    return Objects.equals(tenderer, orther_.tenderer);
  }

  @Override
  public String toString() {
    return "Extend101801 [" + "tenderer=" + this.tenderer + "]";
  }
}
