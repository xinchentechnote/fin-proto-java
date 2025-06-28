package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend200315 implements BinaryCodec {
  private int maturityDate;

  public int getMaturityDate() {
    return this.maturityDate;
  }

  public void setMaturityDate(int maturityDate) {
    this.maturityDate = maturityDate;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.maturityDate);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.maturityDate = byteBuf.readInt();
  }

  @Override
  public int hashCode() {
    return Objects.hash(maturityDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend200315 orther_ = (Extend200315) obj;
    return Objects.equals(maturityDate, orther_.maturityDate);
  }

  @Override
  public String toString() {
    return "Extend200315 [" + "maturityDate=" + this.maturityDate + "]";
  }
}
