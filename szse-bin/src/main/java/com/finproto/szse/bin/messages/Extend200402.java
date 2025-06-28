package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend200402 implements BinaryCodec {
  private long stopPx;
  private long minQty;
  private short maxPriceLevels;
  private byte timeInForce;
  private byte positionEffect;
  private byte coveredOrUncovered;
  private String contractAccountCode;
  private String secondaryOrderId;

  public long getStopPx() {
    return this.stopPx;
  }

  public void setStopPx(long stopPx) {
    this.stopPx = stopPx;
  }

  public long getMinQty() {
    return this.minQty;
  }

  public void setMinQty(long minQty) {
    this.minQty = minQty;
  }

  public short getMaxPriceLevels() {
    return this.maxPriceLevels;
  }

  public void setMaxPriceLevels(short maxPriceLevels) {
    this.maxPriceLevels = maxPriceLevels;
  }

  public byte getTimeInForce() {
    return this.timeInForce;
  }

  public void setTimeInForce(byte timeInForce) {
    this.timeInForce = timeInForce;
  }

  public byte getPositionEffect() {
    return this.positionEffect;
  }

  public void setPositionEffect(byte positionEffect) {
    this.positionEffect = positionEffect;
  }

  public byte getCoveredOrUncovered() {
    return this.coveredOrUncovered;
  }

  public void setCoveredOrUncovered(byte coveredOrUncovered) {
    this.coveredOrUncovered = coveredOrUncovered;
  }

  public String getContractAccountCode() {
    return this.contractAccountCode;
  }

  public void setContractAccountCode(String contractAccountCode) {
    this.contractAccountCode = contractAccountCode;
  }

  public String getSecondaryOrderId() {
    return this.secondaryOrderId;
  }

  public void setSecondaryOrderId(String secondaryOrderId) {
    this.secondaryOrderId = secondaryOrderId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeLong(this.stopPx);
    byteBuf.writeLong(this.minQty);
    byteBuf.writeShort(this.maxPriceLevels);
    byteBuf.writeByte(this.timeInForce);
    byteBuf.writeByte(this.positionEffect);
    byteBuf.writeByte(this.coveredOrUncovered);
    writeFixedString(byteBuf, this.contractAccountCode, 6);
    writeFixedString(byteBuf, this.secondaryOrderId, 16);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.stopPx = byteBuf.readLong();
    this.minQty = byteBuf.readLong();
    this.maxPriceLevels = byteBuf.readShort();
    this.timeInForce = byteBuf.readByte();
    this.positionEffect = byteBuf.readByte();
    this.coveredOrUncovered = byteBuf.readByte();
    this.contractAccountCode = readFixedString(byteBuf, 6);
    this.secondaryOrderId = readFixedString(byteBuf, 16);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        stopPx,
        minQty,
        maxPriceLevels,
        timeInForce,
        positionEffect,
        coveredOrUncovered,
        contractAccountCode,
        secondaryOrderId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend200402 orther_ = (Extend200402) obj;
    return Objects.equals(stopPx, orther_.stopPx)
        && Objects.equals(minQty, orther_.minQty)
        && Objects.equals(maxPriceLevels, orther_.maxPriceLevels)
        && Objects.equals(timeInForce, orther_.timeInForce)
        && Objects.equals(positionEffect, orther_.positionEffect)
        && Objects.equals(coveredOrUncovered, orther_.coveredOrUncovered)
        && Objects.equals(contractAccountCode, orther_.contractAccountCode)
        && Objects.equals(secondaryOrderId, orther_.secondaryOrderId);
  }

  @Override
  public String toString() {
    return "Extend200402 ["
        + "stopPx="
        + this.stopPx
        + ", minQty="
        + this.minQty
        + ", maxPriceLevels="
        + this.maxPriceLevels
        + ", timeInForce="
        + this.timeInForce
        + ", positionEffect="
        + this.positionEffect
        + ", coveredOrUncovered="
        + this.coveredOrUncovered
        + ", contractAccountCode="
        + this.contractAccountCode
        + ", secondaryOrderId="
        + this.secondaryOrderId
        + "]";
  }
}
