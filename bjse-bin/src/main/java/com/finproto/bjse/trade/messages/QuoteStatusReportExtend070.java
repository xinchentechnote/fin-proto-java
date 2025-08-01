// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.bjse.trade.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuoteStatusReportExtend070 implements BinaryCodec {
  private String branchId;
  private String orderId;
  private String execId;
  private String quoteRespId;
  private byte privateQuote;
  private byte side;
  private byte priceType;
  private long validUntilTime;
  private byte cashMargin;
  private String counterPartyPbuid;
  private String memo;
  private List<NoQuote> noQuote;

  public String getBranchId() {
    return this.branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getExecId() {
    return this.execId;
  }

  public void setExecId(String execId) {
    this.execId = execId;
  }

  public String getQuoteRespId() {
    return this.quoteRespId;
  }

  public void setQuoteRespId(String quoteRespId) {
    this.quoteRespId = quoteRespId;
  }

  public byte getPrivateQuote() {
    return this.privateQuote;
  }

  public void setPrivateQuote(byte privateQuote) {
    this.privateQuote = privateQuote;
  }

  public byte getSide() {
    return this.side;
  }

  public void setSide(byte side) {
    this.side = side;
  }

  public byte getPriceType() {
    return this.priceType;
  }

  public void setPriceType(byte priceType) {
    this.priceType = priceType;
  }

  public long getValidUntilTime() {
    return this.validUntilTime;
  }

  public void setValidUntilTime(long validUntilTime) {
    this.validUntilTime = validUntilTime;
  }

  public byte getCashMargin() {
    return this.cashMargin;
  }

  public void setCashMargin(byte cashMargin) {
    this.cashMargin = cashMargin;
  }

  public String getCounterPartyPbuid() {
    return this.counterPartyPbuid;
  }

  public void setCounterPartyPbuid(String counterPartyPbuid) {
    this.counterPartyPbuid = counterPartyPbuid;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public List<NoQuote> getNoQuote() {
    return this.noQuote;
  }

  public void setNoQuote(List<NoQuote> noQuote) {
    this.noQuote = noQuote;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.branchId, 2);
    writeFixedString(byteBuf, this.orderId, 16);
    writeFixedString(byteBuf, this.execId, 16);
    writeFixedString(byteBuf, this.quoteRespId, 10);
    byteBuf.writeByte(this.privateQuote);
    byteBuf.writeByte(this.side);
    byteBuf.writeByte(this.priceType);
    byteBuf.writeLongLE(this.validUntilTime);
    byteBuf.writeByte(this.cashMargin);
    writeFixedString(byteBuf, this.counterPartyPbuid, 6);
    writeFixedString(byteBuf, this.memo, 120);
    if (null == this.noQuote || this.noQuote.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShortLE((short) this.noQuote.size());
      for (int i = 0; i < this.noQuote.size(); i++) {
        this.noQuote.get(i).encode(byteBuf);
      }
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.branchId = readFixedString(byteBuf, 2);
    this.orderId = readFixedString(byteBuf, 16);
    this.execId = readFixedString(byteBuf, 16);
    this.quoteRespId = readFixedString(byteBuf, 10);
    this.privateQuote = byteBuf.readByte();
    this.side = byteBuf.readByte();
    this.priceType = byteBuf.readByte();
    this.validUntilTime = byteBuf.readLongLE();
    this.cashMargin = byteBuf.readByte();
    this.counterPartyPbuid = readFixedString(byteBuf, 6);
    this.memo = readFixedString(byteBuf, 120);
    short noQuoteSize = byteBuf.readShortLE();
    if (noQuoteSize > 0) {
      this.noQuote = new ArrayList<>();
      for (int i = 0; i < noQuoteSize; i++) {
        NoQuote noQuote_ = new NoQuote();
        noQuote_.decode(byteBuf);
        this.noQuote.add(noQuote_);
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        branchId,
        orderId,
        execId,
        quoteRespId,
        privateQuote,
        side,
        priceType,
        validUntilTime,
        cashMargin,
        counterPartyPbuid,
        memo,
        noQuote);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    QuoteStatusReportExtend070 orther_ = (QuoteStatusReportExtend070) obj;
    return Objects.equals(branchId, orther_.branchId)
        && Objects.equals(orderId, orther_.orderId)
        && Objects.equals(execId, orther_.execId)
        && Objects.equals(quoteRespId, orther_.quoteRespId)
        && Objects.equals(privateQuote, orther_.privateQuote)
        && Objects.equals(side, orther_.side)
        && Objects.equals(priceType, orther_.priceType)
        && Objects.equals(validUntilTime, orther_.validUntilTime)
        && Objects.equals(cashMargin, orther_.cashMargin)
        && Objects.equals(counterPartyPbuid, orther_.counterPartyPbuid)
        && Objects.equals(memo, orther_.memo)
        && Objects.equals(noQuote, orther_.noQuote);
  }

  @Override
  public String toString() {
    return "QuoteStatusReportExtend070 ["
        + "branchId="
        + this.branchId
        + ", orderId="
        + this.orderId
        + ", execId="
        + this.execId
        + ", quoteRespId="
        + this.quoteRespId
        + ", privateQuote="
        + this.privateQuote
        + ", side="
        + this.side
        + ", priceType="
        + this.priceType
        + ", validUntilTime="
        + this.validUntilTime
        + ", cashMargin="
        + this.cashMargin
        + ", counterPartyPbuid="
        + this.counterPartyPbuid
        + ", memo="
        + this.memo
        + ", noQuote="
        + this.noQuote
        + "]";
  }

  // Code generated by fin-protoc. DO NOT EDIT.
  public static class NoQuote implements BinaryCodec {
    private String quoteId;
    private long quotePrice;
    private long quoteQty;

    public String getQuoteId() {
      return this.quoteId;
    }

    public void setQuoteId(String quoteId) {
      this.quoteId = quoteId;
    }

    public long getQuotePrice() {
      return this.quotePrice;
    }

    public void setQuotePrice(long quotePrice) {
      this.quotePrice = quotePrice;
    }

    public long getQuoteQty() {
      return this.quoteQty;
    }

    public void setQuoteQty(long quoteQty) {
      this.quoteQty = quoteQty;
    }

    @Override
    public void encode(ByteBuf byteBuf) {
      writeFixedString(byteBuf, this.quoteId, 10);
      byteBuf.writeLongLE(this.quotePrice);
      byteBuf.writeLongLE(this.quoteQty);
    }

    @Override
    public void decode(ByteBuf byteBuf) {
      this.quoteId = readFixedString(byteBuf, 10);
      this.quotePrice = byteBuf.readLongLE();
      this.quoteQty = byteBuf.readLongLE();
    }

    @Override
    public int hashCode() {
      return Objects.hash(quoteId, quotePrice, quoteQty);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (null == obj || getClass() != obj.getClass()) {
        return false;
      }
      NoQuote orther_ = (NoQuote) obj;
      return Objects.equals(quoteId, orther_.quoteId)
          && Objects.equals(quotePrice, orther_.quotePrice)
          && Objects.equals(quoteQty, orther_.quoteQty);
    }

    @Override
    public String toString() {
      return "NoQuote ["
          + "quoteId="
          + this.quoteId
          + ", quotePrice="
          + this.quotePrice
          + ", quoteQty="
          + this.quoteQty
          + "]";
    }
  }
}
