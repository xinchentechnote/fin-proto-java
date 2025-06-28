package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend100701 implements BinaryCodec {
  private short expirationDays;
  private byte expirationType;
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

  public String getShareProperty() {
    return this.shareProperty;
  }

  public void setShareProperty(String shareProperty) {
    this.shareProperty = shareProperty;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.expirationDays);
    byteBuf.writeByte(this.expirationType);
    writeFixedString(byteBuf, this.shareProperty, 2);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.expirationDays = byteBuf.readShort();
    this.expirationType = byteBuf.readByte();
    this.shareProperty = readFixedString(byteBuf, 2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationDays, expirationType, shareProperty);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend100701 orther_ = (Extend100701) obj;
    return Objects.equals(expirationDays, orther_.expirationDays)
        && Objects.equals(expirationType, orther_.expirationType)
        && Objects.equals(shareProperty, orther_.shareProperty);
  }

  @Override
  public String toString() {
    return "Extend100701 ["
        + "expirationDays="
        + this.expirationDays
        + ", expirationType="
        + this.expirationType
        + ", shareProperty="
        + this.shareProperty
        + "]";
  }
}
