package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class OrderReject implements BinaryCodec {
  private int bizId;
  private String bizPbu;
  private String clOrdId;
  private String securityId;
  private int ordRejReason;
  private int tradeDate;
  private long transactTime;
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

  public int getOrdRejReason() {
    return this.ordRejReason;
  }

  public void setOrdRejReason(int ordRejReason) {
    this.ordRejReason = ordRejReason;
  }

  public int getTradeDate() {
    return this.tradeDate;
  }

  public void setTradeDate(int tradeDate) {
    this.tradeDate = tradeDate;
  }

  public long getTransactTime() {
    return this.transactTime;
  }

  public void setTransactTime(long transactTime) {
    this.transactTime = transactTime;
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
    byteBuf.writeInt(this.ordRejReason);
    byteBuf.writeInt(this.tradeDate);
    byteBuf.writeLong(this.transactTime);
    writeFixedString(byteBuf, this.userInfo, 32);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.bizId = byteBuf.readInt();
    this.bizPbu = readFixedString(byteBuf, 8);
    this.clOrdId = readFixedString(byteBuf, 10);
    this.securityId = readFixedString(byteBuf, 12);
    this.ordRejReason = byteBuf.readInt();
    this.tradeDate = byteBuf.readInt();
    this.transactTime = byteBuf.readLong();
    this.userInfo = readFixedString(byteBuf, 32);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        bizId, bizPbu, clOrdId, securityId, ordRejReason, tradeDate, transactTime, userInfo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    OrderReject orther_ = (OrderReject) obj;
    return Objects.equals(bizId, orther_.bizId)
        && Objects.equals(bizPbu, orther_.bizPbu)
        && Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(securityId, orther_.securityId)
        && Objects.equals(ordRejReason, orther_.ordRejReason)
        && Objects.equals(tradeDate, orther_.tradeDate)
        && Objects.equals(transactTime, orther_.transactTime)
        && Objects.equals(userInfo, orther_.userInfo);
  }

  @Override
  public String toString() {
    return "OrderReject ["
        + "bizId="
        + this.bizId
        + ", bizPbu="
        + this.bizPbu
        + ", clOrdId="
        + this.clOrdId
        + ", securityId="
        + this.securityId
        + ", ordRejReason="
        + this.ordRejReason
        + ", tradeDate="
        + this.tradeDate
        + ", transactTime="
        + this.transactTime
        + ", userInfo="
        + this.userInfo
        + "]";
  }
}
