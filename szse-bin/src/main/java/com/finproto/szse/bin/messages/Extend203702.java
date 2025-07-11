// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend203702 implements BinaryCodec {
  private byte cashMargin;

  public byte getCashMargin() {
    return this.cashMargin;
  }

  public void setCashMargin(byte cashMargin) {
    this.cashMargin = cashMargin;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeByte(this.cashMargin);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.cashMargin = byteBuf.readByte();
  }

  @Override
  public int hashCode() {
    return Objects.hash(cashMargin);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend203702 orther_ = (Extend203702) obj;
    return Objects.equals(cashMargin, orther_.cashMargin);
  }

  @Override
  public String toString() {
    return "Extend203702 [" + "cashMargin=" + this.cashMargin + "]";
  }
}
