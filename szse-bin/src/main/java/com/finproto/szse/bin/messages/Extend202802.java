package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend202802 implements BinaryCodec {
  private String lenderPbu;
  private String lenderAccountId;

  public String getLenderPbu() {
    return this.lenderPbu;
  }

  public void setLenderPbu(String lenderPbu) {
    this.lenderPbu = lenderPbu;
  }

  public String getLenderAccountId() {
    return this.lenderAccountId;
  }

  public void setLenderAccountId(String lenderAccountId) {
    this.lenderAccountId = lenderAccountId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.lenderPbu, 6);
    writeFixedString(byteBuf, this.lenderAccountId, 12);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.lenderPbu = readFixedString(byteBuf, 6);
    this.lenderAccountId = readFixedString(byteBuf, 12);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lenderPbu, lenderAccountId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend202802 orther_ = (Extend202802) obj;
    return Objects.equals(lenderPbu, orther_.lenderPbu)
        && Objects.equals(lenderAccountId, orther_.lenderAccountId);
  }

  @Override
  public String toString() {
    return "Extend202802 ["
        + "lenderPbu="
        + this.lenderPbu
        + ", lenderAccountId="
        + this.lenderAccountId
        + "]";
  }
}
