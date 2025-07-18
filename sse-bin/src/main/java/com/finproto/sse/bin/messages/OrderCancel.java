// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class OrderCancel implements BinaryCodec {
  private int bizId;
  private String bizPbu;
  private String clOrdId;
  private String securityId;
  private String account;
  private byte ownerType;
  private String side;
  private String origClOrdId;
  private long transactTime;
  private String branchId;
  private String userInfo;

  public int getBizId() {
    return this.bizId;
  }

  public void setBizId(int bizId) {
    this.bizId = bizId;
  }

  public String getBizPbu() {
    return this.bizPbu;
  }

  public void setBizPbu(String bizPbu) {
    this.bizPbu = bizPbu;
  }

  public String getClOrdId() {
    return this.clOrdId;
  }

  public void setClOrdId(String clOrdId) {
    this.clOrdId = clOrdId;
  }

  public String getSecurityId() {
    return this.securityId;
  }

  public void setSecurityId(String securityId) {
    this.securityId = securityId;
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public byte getOwnerType() {
    return this.ownerType;
  }

  public void setOwnerType(byte ownerType) {
    this.ownerType = ownerType;
  }

  public String getSide() {
    return this.side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public String getOrigClOrdId() {
    return this.origClOrdId;
  }

  public void setOrigClOrdId(String origClOrdId) {
    this.origClOrdId = origClOrdId;
  }

  public long getTransactTime() {
    return this.transactTime;
  }

  public void setTransactTime(long transactTime) {
    this.transactTime = transactTime;
  }

  public String getBranchId() {
    return this.branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getUserInfo() {
    return this.userInfo;
  }

  public void setUserInfo(String userInfo) {
    this.userInfo = userInfo;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.bizId);
    writeFixedString(byteBuf, this.bizPbu, 8);
    writeFixedString(byteBuf, this.clOrdId, 10);
    writeFixedString(byteBuf, this.securityId, 12);
    writeFixedString(byteBuf, this.account, 13);
    byteBuf.writeByte(this.ownerType);
    writeFixedString(byteBuf, this.side, 1);
    writeFixedString(byteBuf, this.origClOrdId, 10);
    byteBuf.writeLong(this.transactTime);
    writeFixedString(byteBuf, this.branchId, 8);
    writeFixedString(byteBuf, this.userInfo, 32);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.bizId = byteBuf.readInt();
    this.bizPbu = readFixedString(byteBuf, 8);
    this.clOrdId = readFixedString(byteBuf, 10);
    this.securityId = readFixedString(byteBuf, 12);
    this.account = readFixedString(byteBuf, 13);
    this.ownerType = byteBuf.readByte();
    this.side = readFixedString(byteBuf, 1);
    this.origClOrdId = readFixedString(byteBuf, 10);
    this.transactTime = byteBuf.readLong();
    this.branchId = readFixedString(byteBuf, 8);
    this.userInfo = readFixedString(byteBuf, 32);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        bizId,
        bizPbu,
        clOrdId,
        securityId,
        account,
        ownerType,
        side,
        origClOrdId,
        transactTime,
        branchId,
        userInfo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    OrderCancel orther_ = (OrderCancel) obj;
    return Objects.equals(bizId, orther_.bizId)
        && Objects.equals(bizPbu, orther_.bizPbu)
        && Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(securityId, orther_.securityId)
        && Objects.equals(account, orther_.account)
        && Objects.equals(ownerType, orther_.ownerType)
        && Objects.equals(side, orther_.side)
        && Objects.equals(origClOrdId, orther_.origClOrdId)
        && Objects.equals(transactTime, orther_.transactTime)
        && Objects.equals(branchId, orther_.branchId)
        && Objects.equals(userInfo, orther_.userInfo);
  }

  @Override
  public String toString() {
    return "OrderCancel ["
        + "bizId="
        + this.bizId
        + ", bizPbu="
        + this.bizPbu
        + ", clOrdId="
        + this.clOrdId
        + ", securityId="
        + this.securityId
        + ", account="
        + this.account
        + ", ownerType="
        + this.ownerType
        + ", side="
        + this.side
        + ", origClOrdId="
        + this.origClOrdId
        + ", transactTime="
        + this.transactTime
        + ", branchId="
        + this.branchId
        + ", userInfo="
        + this.userInfo
        + "]";
  }
}
