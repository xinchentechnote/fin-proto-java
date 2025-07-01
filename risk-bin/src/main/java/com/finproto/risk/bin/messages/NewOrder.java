package com.finproto.risk.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class NewOrder implements BinaryCodec {
  private String clOrdId;
  private String securityId;
  private byte side;
  private long price;
  private long orderQty;
  private byte ordType;
  private String account;

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

  public byte getSide() {
    return this.side;
  }

  public void setSide(byte side) {
    this.side = side;
  }

  public long getPrice() {
    return this.price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public long getOrderQty() {
    return this.orderQty;
  }

  public void setOrderQty(long orderQty) {
    this.orderQty = orderQty;
  }

  public byte getOrdType() {
    return this.ordType;
  }

  public void setOrdType(byte ordType) {
    this.ordType = ordType;
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.clOrdId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.clOrdId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    if (StringUtil.isNullOrEmpty(this.securityId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.securityId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    byteBuf.writeByte(this.side);
    byteBuf.writeLong(this.price);
    byteBuf.writeLong(this.orderQty);
    byteBuf.writeByte(this.ordType);
    if (StringUtil.isNullOrEmpty(this.account)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.account.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    int clOrdIdLen = byteBuf.readInt();
    if (clOrdIdLen > 0) {
      this.clOrdId = byteBuf.readCharSequence(clOrdIdLen, StandardCharsets.UTF_8).toString();
    }
    int securityIdLen = byteBuf.readInt();
    if (securityIdLen > 0) {
      this.securityId = byteBuf.readCharSequence(securityIdLen, StandardCharsets.UTF_8).toString();
    }
    this.side = byteBuf.readByte();
    this.price = byteBuf.readLong();
    this.orderQty = byteBuf.readLong();
    this.ordType = byteBuf.readByte();
    int accountLen = byteBuf.readInt();
    if (accountLen > 0) {
      this.account = byteBuf.readCharSequence(accountLen, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(clOrdId, securityId, side, price, orderQty, ordType, account);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    NewOrder orther_ = (NewOrder) obj;
    return Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(securityId, orther_.securityId)
        && Objects.equals(side, orther_.side)
        && Objects.equals(price, orther_.price)
        && Objects.equals(orderQty, orther_.orderQty)
        && Objects.equals(ordType, orther_.ordType)
        && Objects.equals(account, orther_.account);
  }

  @Override
  public String toString() {
    return "NewOrder ["
        + "clOrdId="
        + this.clOrdId
        + ", securityId="
        + this.securityId
        + ", side="
        + this.side
        + ", price="
        + this.price
        + ", orderQty="
        + this.orderQty
        + ", ordType="
        + this.ordType
        + ", account="
        + this.account
        + "]";
  }
}
