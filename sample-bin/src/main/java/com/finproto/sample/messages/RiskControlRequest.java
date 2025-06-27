package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class RiskControlRequest implements BinaryCodec {
  private String uniqueOrderId;
  private String clOrdId;
  private String marketId;
  private String securityId;
  private byte side;
  private byte orderType;
  private long price;
  private int qty;
  private String extraInfo;
  private SubOrder subOrder;

  public String getUniqueOrderId() {
    return this.uniqueOrderId;
  }

  public void setUniqueOrderId(String uniqueOrderId) {
    this.uniqueOrderId = uniqueOrderId;
  }

  public String getClOrdId() {
    return this.clOrdId;
  }

  public void setClOrdId(String clOrdId) {
    this.clOrdId = clOrdId;
  }

  public String getMarketId() {
    return this.marketId;
  }

  public void setMarketId(String marketId) {
    this.marketId = marketId;
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

  public byte getOrderType() {
    return this.orderType;
  }

  public void setOrderType(byte orderType) {
    this.orderType = orderType;
  }

  public long getPrice() {
    return this.price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getQty() {
    return this.qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public String getExtraInfo() {
    return this.extraInfo;
  }

  public void setExtraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
  }

  public SubOrder getSubOrder() {
    return this.subOrder;
  }

  public void setSubOrder(SubOrder subOrder) {
    this.subOrder = subOrder;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.uniqueOrderId)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.uniqueOrderId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    writeFixedString(byteBuf, this.clOrdId, 16);
    writeFixedString(byteBuf, this.marketId, 3);
    writeFixedString(byteBuf, this.securityId, 12);
    byteBuf.writeByte(this.side);
    byteBuf.writeByte(this.orderType);
    byteBuf.writeLong(this.price);
    byteBuf.writeInt(this.qty);
    if (StringUtil.isNullOrEmpty(this.extraInfo)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.extraInfo.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    if (null == this.subOrder) {
      this.subOrder = new SubOrder();
    }
    this.subOrder.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short uniqueOrderIdLen = byteBuf.readShort();
    if (uniqueOrderIdLen > 0) {
      this.uniqueOrderId =
          byteBuf.readCharSequence(uniqueOrderIdLen, StandardCharsets.UTF_8).toString();
    }
    this.clOrdId = readFixedString(byteBuf, 16);
    this.marketId = readFixedString(byteBuf, 3);
    this.securityId = readFixedString(byteBuf, 12);
    this.side = byteBuf.readByte();
    this.orderType = byteBuf.readByte();
    this.price = byteBuf.readLong();
    this.qty = byteBuf.readInt();
    short extraInfoLen = byteBuf.readShort();
    if (extraInfoLen > 0) {
      this.extraInfo = byteBuf.readCharSequence(extraInfoLen, StandardCharsets.UTF_8).toString();
    }
    if (null == this.subOrder) {
      this.subOrder = new SubOrder();
    }
    this.subOrder.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        uniqueOrderId,
        clOrdId,
        marketId,
        securityId,
        side,
        orderType,
        price,
        qty,
        extraInfo,
        subOrder);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    RiskControlRequest riskControlRequest = (RiskControlRequest) obj;
    return Objects.equals(uniqueOrderId, riskControlRequest.uniqueOrderId)
        && Objects.equals(clOrdId, riskControlRequest.clOrdId)
        && Objects.equals(marketId, riskControlRequest.marketId)
        && Objects.equals(securityId, riskControlRequest.securityId)
        && Objects.equals(side, riskControlRequest.side)
        && Objects.equals(orderType, riskControlRequest.orderType)
        && Objects.equals(price, riskControlRequest.price)
        && Objects.equals(qty, riskControlRequest.qty)
        && Objects.equals(extraInfo, riskControlRequest.extraInfo)
        && Objects.equals(subOrder, riskControlRequest.subOrder);
  }

  @Override
  public String toString() {
    return "RiskControlRequest ["
        + "uniqueOrderId="
        + this.uniqueOrderId
        + ", clOrdId="
        + this.clOrdId
        + ", marketId="
        + this.marketId
        + ", securityId="
        + this.securityId
        + ", side="
        + this.side
        + ", orderType="
        + this.orderType
        + ", price="
        + this.price
        + ", qty="
        + this.qty
        + ", extraInfo="
        + this.extraInfo
        + ", subOrder="
        + this.subOrder
        + "]";
  }

  public static class SubOrder implements BinaryCodec {
    private String clOrdId;
    private long price;
    private int qty;

    public String getClOrdId() {
      return this.clOrdId;
    }

    public void setClOrdId(String clOrdId) {
      this.clOrdId = clOrdId;
    }

    public long getPrice() {
      return this.price;
    }

    public void setPrice(long price) {
      this.price = price;
    }

    public int getQty() {
      return this.qty;
    }

    public void setQty(int qty) {
      this.qty = qty;
    }

    @Override
    public void encode(ByteBuf byteBuf) {
      writeFixedString(byteBuf, this.clOrdId, 16);
      byteBuf.writeLong(this.price);
      byteBuf.writeInt(this.qty);
    }

    @Override
    public void decode(ByteBuf byteBuf) {
      this.clOrdId = readFixedString(byteBuf, 16);
      this.price = byteBuf.readLong();
      this.qty = byteBuf.readInt();
    }

    @Override
    public int hashCode() {
      return Objects.hash(clOrdId, price, qty);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (null == obj || getClass() != obj.getClass()) {
        return false;
      }
      SubOrder subOrder = (SubOrder) obj;
      return Objects.equals(clOrdId, subOrder.clOrdId)
          && Objects.equals(price, subOrder.price)
          && Objects.equals(qty, subOrder.qty);
    }

    @Override
    public String toString() {
      return "SubOrder ["
          + "clOrdId="
          + this.clOrdId
          + ", price="
          + this.price
          + ", qty="
          + this.qty
          + "]";
    }
  }
}
