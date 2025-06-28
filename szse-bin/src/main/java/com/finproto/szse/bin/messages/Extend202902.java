package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend202902 implements BinaryCodec {
  private String deductionPbu;
  private String deductionAccountId;

  public String getDeductionPbu() {
    return this.deductionPbu;
  }

  public void setDeductionPbu(String deductionPbu) {
    this.deductionPbu = deductionPbu;
  }

  public String getDeductionAccountId() {
    return this.deductionAccountId;
  }

  public void setDeductionAccountId(String deductionAccountId) {
    this.deductionAccountId = deductionAccountId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.deductionPbu, 6);
    writeFixedString(byteBuf, this.deductionAccountId, 12);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.deductionPbu = readFixedString(byteBuf, 6);
    this.deductionAccountId = readFixedString(byteBuf, 12);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deductionPbu, deductionAccountId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend202902 orther_ = (Extend202902) obj;
    return Objects.equals(deductionPbu, orther_.deductionPbu)
        && Objects.equals(deductionAccountId, orther_.deductionAccountId);
  }

  @Override
  public String toString() {
    return "Extend202902 ["
        + "deductionPbu="
        + this.deductionPbu
        + ", deductionAccountId="
        + this.deductionAccountId
        + "]";
  }
}
