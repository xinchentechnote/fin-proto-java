// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.bjse.trade.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ReportExtend050 implements BinaryCodec {
  private short expirationDays;
  private byte expirationType;
  private int maturityDate;
  private String shareProperty;

  public short getExpirationDays() {
    return this.expirationDays;
  }

  public void setExpirationDays(short expirationDays) {
    this.expirationDays = expirationDays;
  }

  public byte getExpirationType() {
    return this.expirationType;
  }

  public void setExpirationType(byte expirationType) {
    this.expirationType = expirationType;
  }

  public int getMaturityDate() {
    return this.maturityDate;
  }

  public void setMaturityDate(int maturityDate) {
    this.maturityDate = maturityDate;
  }

  public String getShareProperty() {
    return this.shareProperty;
  }

  public void setShareProperty(String shareProperty) {
    this.shareProperty = shareProperty;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShortLE(this.expirationDays);
    byteBuf.writeByte(this.expirationType);
    byteBuf.writeIntLE(this.maturityDate);
    writeFixedString(byteBuf, this.shareProperty, 2);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.expirationDays = byteBuf.readShortLE();
    this.expirationType = byteBuf.readByte();
    this.maturityDate = byteBuf.readIntLE();
    this.shareProperty = readFixedString(byteBuf, 2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationDays, expirationType, maturityDate, shareProperty);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ReportExtend050 orther_ = (ReportExtend050) obj;
    return Objects.equals(expirationDays, orther_.expirationDays)
        && Objects.equals(expirationType, orther_.expirationType)
        && Objects.equals(maturityDate, orther_.maturityDate)
        && Objects.equals(shareProperty, orther_.shareProperty);
  }

  @Override
  public String toString() {
    return "ReportExtend050 ["
        + "expirationDays="
        + this.expirationDays
        + ", expirationType="
        + this.expirationType
        + ", maturityDate="
        + this.maturityDate
        + ", shareProperty="
        + this.shareProperty
        + "]";
  }
}
