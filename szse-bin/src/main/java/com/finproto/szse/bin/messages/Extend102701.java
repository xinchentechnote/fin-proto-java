package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend102701 implements BinaryCodec {
  private String disposalPbu;
  private String disposalAccountId;

  public String getDisposalPbu() {
    return this.disposalPbu;
  }

  public void setDisposalPbu(String disposalPbu) {
    this.disposalPbu = disposalPbu;
  }

  public String getDisposalAccountId() {
    return this.disposalAccountId;
  }

  public void setDisposalAccountId(String disposalAccountId) {
    this.disposalAccountId = disposalAccountId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.disposalPbu, 6);
    writeFixedString(byteBuf, this.disposalAccountId, 12);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.disposalPbu = readFixedString(byteBuf, 6);
    this.disposalAccountId = readFixedString(byteBuf, 12);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disposalPbu, disposalAccountId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend102701 orther_ = (Extend102701) obj;
    return Objects.equals(disposalPbu, orther_.disposalPbu)
        && Objects.equals(disposalAccountId, orther_.disposalAccountId);
  }

  @Override
  public String toString() {
    return "Extend102701 ["
        + "disposalPbu="
        + this.disposalPbu
        + ", disposalAccountId="
        + this.disposalAccountId
        + "]";
  }
}
