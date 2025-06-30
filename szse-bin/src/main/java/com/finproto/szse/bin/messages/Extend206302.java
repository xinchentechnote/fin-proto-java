package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Extend206302 implements BinaryCodec {
  private String rejectText;
  private long stopPx;
  private long minQty;
  private short maxPriceLevels;
  private byte timeInForce;
  private byte lotType;
  private int imcrejectTextLen;
  private String imcrejectText;

  public String getRejectText() {
    return this.rejectText;
  }

  public void setRejectText(String rejectText) {
    this.rejectText = rejectText;
  }

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

  public int getImcrejectTextLen() {
    return this.imcrejectTextLen;
  }

  public void setImcrejectTextLen(int imcrejectTextLen) {
    this.imcrejectTextLen = imcrejectTextLen;
  }

  public String getImcrejectText() {
    return this.imcrejectText;
  }

  public void setImcrejectText(String imcrejectText) {
    this.imcrejectText = imcrejectText;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.rejectText, 16);
    byteBuf.writeLong(this.stopPx);
    byteBuf.writeLong(this.minQty);
    byteBuf.writeShort(this.maxPriceLevels);
    byteBuf.writeByte(this.timeInForce);
    byteBuf.writeByte(this.lotType);
    byteBuf.writeInt(this.imcrejectTextLen);
    if (StringUtil.isNullOrEmpty(this.imcrejectText)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.imcrejectText.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.rejectText = readFixedString(byteBuf, 16);
    this.stopPx = byteBuf.readLong();
    this.minQty = byteBuf.readLong();
    this.maxPriceLevels = byteBuf.readShort();
    this.timeInForce = byteBuf.readByte();
    this.lotType = byteBuf.readByte();
    this.imcrejectTextLen = byteBuf.readInt();
    int imcrejectTextLen = byteBuf.readInt();
    if (imcrejectTextLen > 0) {
      this.imcrejectText =
          byteBuf.readCharSequence(imcrejectTextLen, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        rejectText,
        stopPx,
        minQty,
        maxPriceLevels,
        timeInForce,
        lotType,
        imcrejectTextLen,
        imcrejectText);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend206302 orther_ = (Extend206302) obj;
    return Objects.equals(rejectText, orther_.rejectText)
        && Objects.equals(stopPx, orther_.stopPx)
        && Objects.equals(minQty, orther_.minQty)
        && Objects.equals(maxPriceLevels, orther_.maxPriceLevels)
        && Objects.equals(timeInForce, orther_.timeInForce)
        && Objects.equals(lotType, orther_.lotType)
        && Objects.equals(imcrejectTextLen, orther_.imcrejectTextLen)
        && Objects.equals(imcrejectText, orther_.imcrejectText);
  }

  @Override
  public String toString() {
    return "Extend206302 ["
        + "rejectText="
        + this.rejectText
        + ", stopPx="
        + this.stopPx
        + ", minQty="
        + this.minQty
        + ", maxPriceLevels="
        + this.maxPriceLevels
        + ", timeInForce="
        + this.timeInForce
        + ", lotType="
        + this.lotType
        + ", imcrejectTextLen="
        + this.imcrejectTextLen
        + ", imcrejectText="
        + this.imcrejectText
        + "]";
  }
}
