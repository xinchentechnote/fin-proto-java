package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend204130 implements BinaryCodec {
  private String memberId;
  private String investorType;
  private String investorId;
  private String investorName;
  private String traderCode;
  private String counterpartyMemberId;
  private String counterpartyInvestorType;
  private String counterpartyInvestorId;
  private String counterpartyInvestorName;
  private String counterpartyTraderCode;
  private String secondaryOrderId;
  private short bidTransType;
  private short bidExecInstType;
  private short settlType;
  private byte settlPeriod;
  private byte cashMargin;
  private String memo;

  public String getMemberId() {
    return this.memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getInvestorType() {
    return this.investorType;
  }

  public void setInvestorType(String investorType) {
    this.investorType = investorType;
  }

  public String getInvestorId() {
    return this.investorId;
  }

  public void setInvestorId(String investorId) {
    this.investorId = investorId;
  }

  public String getInvestorName() {
    return this.investorName;
  }

  public void setInvestorName(String investorName) {
    this.investorName = investorName;
  }

  public String getTraderCode() {
    return this.traderCode;
  }

  public void setTraderCode(String traderCode) {
    this.traderCode = traderCode;
  }

  public String getCounterpartyMemberId() {
    return this.counterpartyMemberId;
  }

  public void setCounterpartyMemberId(String counterpartyMemberId) {
    this.counterpartyMemberId = counterpartyMemberId;
  }

  public String getCounterpartyInvestorType() {
    return this.counterpartyInvestorType;
  }

  public void setCounterpartyInvestorType(String counterpartyInvestorType) {
    this.counterpartyInvestorType = counterpartyInvestorType;
  }

  public String getCounterpartyInvestorId() {
    return this.counterpartyInvestorId;
  }

  public void setCounterpartyInvestorId(String counterpartyInvestorId) {
    this.counterpartyInvestorId = counterpartyInvestorId;
  }

  public String getCounterpartyInvestorName() {
    return this.counterpartyInvestorName;
  }

  public void setCounterpartyInvestorName(String counterpartyInvestorName) {
    this.counterpartyInvestorName = counterpartyInvestorName;
  }

  public String getCounterpartyTraderCode() {
    return this.counterpartyTraderCode;
  }

  public void setCounterpartyTraderCode(String counterpartyTraderCode) {
    this.counterpartyTraderCode = counterpartyTraderCode;
  }

  public String getSecondaryOrderId() {
    return this.secondaryOrderId;
  }

  public void setSecondaryOrderId(String secondaryOrderId) {
    this.secondaryOrderId = secondaryOrderId;
  }

  public short getBidTransType() {
    return this.bidTransType;
  }

  public void setBidTransType(short bidTransType) {
    this.bidTransType = bidTransType;
  }

  public short getBidExecInstType() {
    return this.bidExecInstType;
  }

  public void setBidExecInstType(short bidExecInstType) {
    this.bidExecInstType = bidExecInstType;
  }

  public short getSettlType() {
    return this.settlType;
  }

  public void setSettlType(short settlType) {
    this.settlType = settlType;
  }

  public byte getSettlPeriod() {
    return this.settlPeriod;
  }

  public void setSettlPeriod(byte settlPeriod) {
    this.settlPeriod = settlPeriod;
  }

  public byte getCashMargin() {
    return this.cashMargin;
  }

  public void setCashMargin(byte cashMargin) {
    this.cashMargin = cashMargin;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.memberId, 6);
    writeFixedString(byteBuf, this.investorType, 2);
    writeFixedString(byteBuf, this.investorId, 10);
    writeFixedString(byteBuf, this.investorName, 120);
    writeFixedString(byteBuf, this.traderCode, 8);
    writeFixedString(byteBuf, this.counterpartyMemberId, 6);
    writeFixedString(byteBuf, this.counterpartyInvestorType, 2);
    writeFixedString(byteBuf, this.counterpartyInvestorId, 10);
    writeFixedString(byteBuf, this.counterpartyInvestorName, 120);
    writeFixedString(byteBuf, this.counterpartyTraderCode, 8);
    writeFixedString(byteBuf, this.secondaryOrderId, 16);
    byteBuf.writeShort(this.bidTransType);
    byteBuf.writeShort(this.bidExecInstType);
    byteBuf.writeShort(this.settlType);
    byteBuf.writeByte(this.settlPeriod);
    byteBuf.writeByte(this.cashMargin);
    writeFixedString(byteBuf, this.memo, 160);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.memberId = readFixedString(byteBuf, 6);
    this.investorType = readFixedString(byteBuf, 2);
    this.investorId = readFixedString(byteBuf, 10);
    this.investorName = readFixedString(byteBuf, 120);
    this.traderCode = readFixedString(byteBuf, 8);
    this.counterpartyMemberId = readFixedString(byteBuf, 6);
    this.counterpartyInvestorType = readFixedString(byteBuf, 2);
    this.counterpartyInvestorId = readFixedString(byteBuf, 10);
    this.counterpartyInvestorName = readFixedString(byteBuf, 120);
    this.counterpartyTraderCode = readFixedString(byteBuf, 8);
    this.secondaryOrderId = readFixedString(byteBuf, 16);
    this.bidTransType = byteBuf.readShort();
    this.bidExecInstType = byteBuf.readShort();
    this.settlType = byteBuf.readShort();
    this.settlPeriod = byteBuf.readByte();
    this.cashMargin = byteBuf.readByte();
    this.memo = readFixedString(byteBuf, 160);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        memberId,
        investorType,
        investorId,
        investorName,
        traderCode,
        counterpartyMemberId,
        counterpartyInvestorType,
        counterpartyInvestorId,
        counterpartyInvestorName,
        counterpartyTraderCode,
        secondaryOrderId,
        bidTransType,
        bidExecInstType,
        settlType,
        settlPeriod,
        cashMargin,
        memo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend204130 orther_ = (Extend204130) obj;
    return Objects.equals(memberId, orther_.memberId)
        && Objects.equals(investorType, orther_.investorType)
        && Objects.equals(investorId, orther_.investorId)
        && Objects.equals(investorName, orther_.investorName)
        && Objects.equals(traderCode, orther_.traderCode)
        && Objects.equals(counterpartyMemberId, orther_.counterpartyMemberId)
        && Objects.equals(counterpartyInvestorType, orther_.counterpartyInvestorType)
        && Objects.equals(counterpartyInvestorId, orther_.counterpartyInvestorId)
        && Objects.equals(counterpartyInvestorName, orther_.counterpartyInvestorName)
        && Objects.equals(counterpartyTraderCode, orther_.counterpartyTraderCode)
        && Objects.equals(secondaryOrderId, orther_.secondaryOrderId)
        && Objects.equals(bidTransType, orther_.bidTransType)
        && Objects.equals(bidExecInstType, orther_.bidExecInstType)
        && Objects.equals(settlType, orther_.settlType)
        && Objects.equals(settlPeriod, orther_.settlPeriod)
        && Objects.equals(cashMargin, orther_.cashMargin)
        && Objects.equals(memo, orther_.memo);
  }

  @Override
  public String toString() {
    return "Extend204130 ["
        + "memberId="
        + this.memberId
        + ", investorType="
        + this.investorType
        + ", investorId="
        + this.investorId
        + ", investorName="
        + this.investorName
        + ", traderCode="
        + this.traderCode
        + ", counterpartyMemberId="
        + this.counterpartyMemberId
        + ", counterpartyInvestorType="
        + this.counterpartyInvestorType
        + ", counterpartyInvestorId="
        + this.counterpartyInvestorId
        + ", counterpartyInvestorName="
        + this.counterpartyInvestorName
        + ", counterpartyTraderCode="
        + this.counterpartyTraderCode
        + ", secondaryOrderId="
        + this.secondaryOrderId
        + ", bidTransType="
        + this.bidTransType
        + ", bidExecInstType="
        + this.bidExecInstType
        + ", settlType="
        + this.settlType
        + ", settlPeriod="
        + this.settlPeriod
        + ", cashMargin="
        + this.cashMargin
        + ", memo="
        + this.memo
        + "]";
  }
}
