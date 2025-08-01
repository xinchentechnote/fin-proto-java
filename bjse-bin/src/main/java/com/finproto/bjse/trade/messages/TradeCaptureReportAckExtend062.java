// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.bjse.trade.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class TradeCaptureReportAckExtend062 implements BinaryCodec {
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
    TradeCaptureReportAckExtend062 orther_ = (TradeCaptureReportAckExtend062) obj;
    return Objects.equals(cashMargin, orther_.cashMargin);
  }

  @Override
  public String toString() {
    return "TradeCaptureReportAckExtend062 [" + "cashMargin=" + this.cashMargin + "]";
  }
}
