// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend106301 implements BinaryCodec {
  private long stopPx;
  private long minQty;
  private short maxPriceLevels;
  private byte timeInForce;
  private byte lotType;

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

  public byte getLotType() {
    return this.lotType;
  }

  public void setLotType(byte lotType) {
    this.lotType = lotType;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeLong(this.stopPx);
    byteBuf.writeLong(this.minQty);
    byteBuf.writeShort(this.maxPriceLevels);
    byteBuf.writeByte(this.timeInForce);
    byteBuf.writeByte(this.lotType);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.stopPx = byteBuf.readLong();
    this.minQty = byteBuf.readLong();
    this.maxPriceLevels = byteBuf.readShort();
    this.timeInForce = byteBuf.readByte();
    this.lotType = byteBuf.readByte();
  }

  @Override
  public int hashCode() {
    return Objects.hash(stopPx, minQty, maxPriceLevels, timeInForce, lotType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend106301 orther_ = (Extend106301) obj;
    return Objects.equals(stopPx, orther_.stopPx)
        && Objects.equals(minQty, orther_.minQty)
        && Objects.equals(maxPriceLevels, orther_.maxPriceLevels)
        && Objects.equals(timeInForce, orther_.timeInForce)
        && Objects.equals(lotType, orther_.lotType);
  }

  @Override
  public String toString() {
    return "Extend106301 ["
        + "stopPx="
        + this.stopPx
        + ", minQty="
        + this.minQty
        + ", maxPriceLevels="
        + this.maxPriceLevels
        + ", timeInForce="
        + this.timeInForce
        + ", lotType="
        + this.lotType
        + "]";
  }
}
