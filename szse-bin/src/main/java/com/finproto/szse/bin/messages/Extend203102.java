package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend203102 implements BinaryCodec {
  private String insufficientSecurityId;
  private int noSecurity;
  private String underlyingSecurityId;
  private String underlyingSecurityIdsource;
  private long deliveryQty;

  public String getInsufficientSecurityId() {
    return this.insufficientSecurityId;
  }

  public void setInsufficientSecurityId(String insufficientSecurityId) {
    this.insufficientSecurityId = insufficientSecurityId;
  }

  public int getNoSecurity() {
    return this.noSecurity;
  }

  public void setNoSecurity(int noSecurity) {
    this.noSecurity = noSecurity;
  }

  public String getUnderlyingSecurityId() {
    return this.underlyingSecurityId;
  }

  public void setUnderlyingSecurityId(String underlyingSecurityId) {
    this.underlyingSecurityId = underlyingSecurityId;
  }

  public String getUnderlyingSecurityIdsource() {
    return this.underlyingSecurityIdsource;
  }

  public void setUnderlyingSecurityIdsource(String underlyingSecurityIdsource) {
    this.underlyingSecurityIdsource = underlyingSecurityIdsource;
  }

  public long getDeliveryQty() {
    return this.deliveryQty;
  }

  public void setDeliveryQty(long deliveryQty) {
    this.deliveryQty = deliveryQty;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.insufficientSecurityId, 8);
    byteBuf.writeInt(this.noSecurity);
    writeFixedString(byteBuf, this.underlyingSecurityId, 8);
    writeFixedString(byteBuf, this.underlyingSecurityIdsource, 4);
    byteBuf.writeLong(this.deliveryQty);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.insufficientSecurityId = readFixedString(byteBuf, 8);
    this.noSecurity = byteBuf.readInt();
    this.underlyingSecurityId = readFixedString(byteBuf, 8);
    this.underlyingSecurityIdsource = readFixedString(byteBuf, 4);
    this.deliveryQty = byteBuf.readLong();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        insufficientSecurityId,
        noSecurity,
        underlyingSecurityId,
        underlyingSecurityIdsource,
        deliveryQty);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend203102 orther_ = (Extend203102) obj;
    return Objects.equals(insufficientSecurityId, orther_.insufficientSecurityId)
        && Objects.equals(noSecurity, orther_.noSecurity)
        && Objects.equals(underlyingSecurityId, orther_.underlyingSecurityId)
        && Objects.equals(underlyingSecurityIdsource, orther_.underlyingSecurityIdsource)
        && Objects.equals(deliveryQty, orther_.deliveryQty);
  }

  @Override
  public String toString() {
    return "Extend203102 ["
        + "insufficientSecurityId="
        + this.insufficientSecurityId
        + ", noSecurity="
        + this.noSecurity
        + ", underlyingSecurityId="
        + this.underlyingSecurityId
        + ", underlyingSecurityIdsource="
        + this.underlyingSecurityIdsource
        + ", deliveryQty="
        + this.deliveryQty
        + "]";
  }
}
