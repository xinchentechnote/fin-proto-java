// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.bjse.trade.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class TradeCaptureCofirm implements BinaryCodec {
  private int partitionNo;
  private long reportIndex;
  private String applId;
  private String reportingPbuid;
  private String submittingPbuid;
  private String securityId;
  private String securityIdsource;
  private short ownerType;
  private String clearingFirm;
  private long transactTime;
  private String userInfo;
  private String tradeId;
  private String tradeReportId;
  private byte tradeReportType;
  private byte tradeReportTransType;
  private byte tradeHandlingInstr;
  private long lastPx;
  private long lastQty;
  private short trdType;
  private short trdSubType;
  private int confirmId;
  private String execId;
  private byte side;
  private String pbuid;
  private String accountId;
  private String branchId;
  private String counterPartyPbuid;
  private String counterPartyAccountId;
  private String counterPartyBranchId;
  private BinaryCodec applExtend;

  public int getPartitionNo() {
    return this.partitionNo;
  }

  public void setPartitionNo(int partitionNo) {
    this.partitionNo = partitionNo;
  }

  public long getReportIndex() {
    return this.reportIndex;
  }

  public void setReportIndex(long reportIndex) {
    this.reportIndex = reportIndex;
  }

  public String getApplId() {
    return this.applId;
  }

  public void setApplId(String applId) {
    this.applId = applId;
  }

  public String getReportingPbuid() {
    return this.reportingPbuid;
  }

  public void setReportingPbuid(String reportingPbuid) {
    this.reportingPbuid = reportingPbuid;
  }

  public String getSubmittingPbuid() {
    return this.submittingPbuid;
  }

  public void setSubmittingPbuid(String submittingPbuid) {
    this.submittingPbuid = submittingPbuid;
  }

  public String getSecurityId() {
    return this.securityId;
  }

  public void setSecurityId(String securityId) {
    this.securityId = securityId;
  }

  public String getSecurityIdsource() {
    return this.securityIdsource;
  }

  public void setSecurityIdsource(String securityIdsource) {
    this.securityIdsource = securityIdsource;
  }

  public short getOwnerType() {
    return this.ownerType;
  }

  public void setOwnerType(short ownerType) {
    this.ownerType = ownerType;
  }

  public String getClearingFirm() {
    return this.clearingFirm;
  }

  public void setClearingFirm(String clearingFirm) {
    this.clearingFirm = clearingFirm;
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

  public String getTradeId() {
    return this.tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public String getTradeReportId() {
    return this.tradeReportId;
  }

  public void setTradeReportId(String tradeReportId) {
    this.tradeReportId = tradeReportId;
  }

  public byte getTradeReportType() {
    return this.tradeReportType;
  }

  public void setTradeReportType(byte tradeReportType) {
    this.tradeReportType = tradeReportType;
  }

  public byte getTradeReportTransType() {
    return this.tradeReportTransType;
  }

  public void setTradeReportTransType(byte tradeReportTransType) {
    this.tradeReportTransType = tradeReportTransType;
  }

  public byte getTradeHandlingInstr() {
    return this.tradeHandlingInstr;
  }

  public void setTradeHandlingInstr(byte tradeHandlingInstr) {
    this.tradeHandlingInstr = tradeHandlingInstr;
  }

  public long getLastPx() {
    return this.lastPx;
  }

  public void setLastPx(long lastPx) {
    this.lastPx = lastPx;
  }

  public long getLastQty() {
    return this.lastQty;
  }

  public void setLastQty(long lastQty) {
    this.lastQty = lastQty;
  }

  public short getTrdType() {
    return this.trdType;
  }

  public void setTrdType(short trdType) {
    this.trdType = trdType;
  }

  public short getTrdSubType() {
    return this.trdSubType;
  }

  public void setTrdSubType(short trdSubType) {
    this.trdSubType = trdSubType;
  }

  public int getConfirmId() {
    return this.confirmId;
  }

  public void setConfirmId(int confirmId) {
    this.confirmId = confirmId;
  }

  public String getExecId() {
    return this.execId;
  }

  public void setExecId(String execId) {
    this.execId = execId;
  }

  public byte getSide() {
    return this.side;
  }

  public void setSide(byte side) {
    this.side = side;
  }

  public String getPbuid() {
    return this.pbuid;
  }

  public void setPbuid(String pbuid) {
    this.pbuid = pbuid;
  }

  public String getAccountId() {
    return this.accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getBranchId() {
    return this.branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }

  public String getCounterPartyPbuid() {
    return this.counterPartyPbuid;
  }

  public void setCounterPartyPbuid(String counterPartyPbuid) {
    this.counterPartyPbuid = counterPartyPbuid;
  }

  public String getCounterPartyAccountId() {
    return this.counterPartyAccountId;
  }

  public void setCounterPartyAccountId(String counterPartyAccountId) {
    this.counterPartyAccountId = counterPartyAccountId;
  }

  public String getCounterPartyBranchId() {
    return this.counterPartyBranchId;
  }

  public void setCounterPartyBranchId(String counterPartyBranchId) {
    this.counterPartyBranchId = counterPartyBranchId;
  }

  public BinaryCodec getApplExtend() {
    return this.applExtend;
  }

  public void setApplExtend(BinaryCodec applExtend) {
    this.applExtend = applExtend;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeIntLE(this.partitionNo);
    byteBuf.writeLongLE(this.reportIndex);
    writeFixedString(byteBuf, this.applId, 3);
    writeFixedString(byteBuf, this.reportingPbuid, 6);
    writeFixedString(byteBuf, this.submittingPbuid, 6);
    writeFixedString(byteBuf, this.securityId, 8);
    writeFixedString(byteBuf, this.securityIdsource, 4);
    byteBuf.writeShortLE(this.ownerType);
    writeFixedString(byteBuf, this.clearingFirm, 2);
    byteBuf.writeLongLE(this.transactTime);
    writeFixedString(byteBuf, this.userInfo, 32);
    writeFixedString(byteBuf, this.tradeId, 16);
    writeFixedString(byteBuf, this.tradeReportId, 10);
    byteBuf.writeByte(this.tradeReportType);
    byteBuf.writeByte(this.tradeReportTransType);
    byteBuf.writeByte(this.tradeHandlingInstr);
    byteBuf.writeLongLE(this.lastPx);
    byteBuf.writeLongLE(this.lastQty);
    byteBuf.writeShortLE(this.trdType);
    byteBuf.writeShortLE(this.trdSubType);
    byteBuf.writeIntLE(this.confirmId);
    writeFixedString(byteBuf, this.execId, 16);
    byteBuf.writeByte(this.side);
    writeFixedString(byteBuf, this.pbuid, 6);
    writeFixedString(byteBuf, this.accountId, 10);
    writeFixedString(byteBuf, this.branchId, 2);
    writeFixedString(byteBuf, this.counterPartyPbuid, 6);
    writeFixedString(byteBuf, this.counterPartyAccountId, 10);
    writeFixedString(byteBuf, this.counterPartyBranchId, 2);
    if (null != this.applExtend) {
      this.applExtend.encode(byteBuf);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.partitionNo = byteBuf.readIntLE();
    this.reportIndex = byteBuf.readLongLE();
    this.applId = readFixedString(byteBuf, 3);
    this.reportingPbuid = readFixedString(byteBuf, 6);
    this.submittingPbuid = readFixedString(byteBuf, 6);
    this.securityId = readFixedString(byteBuf, 8);
    this.securityIdsource = readFixedString(byteBuf, 4);
    this.ownerType = byteBuf.readShortLE();
    this.clearingFirm = readFixedString(byteBuf, 2);
    this.transactTime = byteBuf.readLongLE();
    this.userInfo = readFixedString(byteBuf, 32);
    this.tradeId = readFixedString(byteBuf, 16);
    this.tradeReportId = readFixedString(byteBuf, 10);
    this.tradeReportType = byteBuf.readByte();
    this.tradeReportTransType = byteBuf.readByte();
    this.tradeHandlingInstr = byteBuf.readByte();
    this.lastPx = byteBuf.readLongLE();
    this.lastQty = byteBuf.readLongLE();
    this.trdType = byteBuf.readShortLE();
    this.trdSubType = byteBuf.readShortLE();
    this.confirmId = byteBuf.readIntLE();
    this.execId = readFixedString(byteBuf, 16);
    this.side = byteBuf.readByte();
    this.pbuid = readFixedString(byteBuf, 6);
    this.accountId = readFixedString(byteBuf, 10);
    this.branchId = readFixedString(byteBuf, 2);
    this.counterPartyPbuid = readFixedString(byteBuf, 6);
    this.counterPartyAccountId = readFixedString(byteBuf, 10);
    this.counterPartyBranchId = readFixedString(byteBuf, 2);
    this.applExtend = createApplExtend(this.applId);
    this.applExtend.decode(byteBuf);
  }

  private static final Map<String, Supplier<BinaryCodec>> applExtendMap = new HashMap<>();

  static {
    applExtendMap.put("031", TradeCaptureCofirmExtend031::new);
    applExtendMap.put("051", TradeCaptureCofirmExtend051::new);
    applExtendMap.put("060", TradeCaptureCofirmExtend060::new);
    applExtendMap.put("061", TradeCaptureCofirmExtend061::new);
    applExtendMap.put("062", TradeCaptureCofirmExtend062::new);
  }

  private BinaryCodec createApplExtend(String applId) {
    Supplier<BinaryCodec> supplier = applExtendMap.get(applId);
    if (null == supplier) {
      throw new IllegalArgumentException("Unsupported ApplID:" + applId);
    }
    return supplier.get();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        partitionNo,
        reportIndex,
        applId,
        reportingPbuid,
        submittingPbuid,
        securityId,
        securityIdsource,
        ownerType,
        clearingFirm,
        transactTime,
        userInfo,
        tradeId,
        tradeReportId,
        tradeReportType,
        tradeReportTransType,
        tradeHandlingInstr,
        lastPx,
        lastQty,
        trdType,
        trdSubType,
        confirmId,
        execId,
        side,
        pbuid,
        accountId,
        branchId,
        counterPartyPbuid,
        counterPartyAccountId,
        counterPartyBranchId,
        applExtend);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    TradeCaptureCofirm orther_ = (TradeCaptureCofirm) obj;
    return Objects.equals(partitionNo, orther_.partitionNo)
        && Objects.equals(reportIndex, orther_.reportIndex)
        && Objects.equals(applId, orther_.applId)
        && Objects.equals(reportingPbuid, orther_.reportingPbuid)
        && Objects.equals(submittingPbuid, orther_.submittingPbuid)
        && Objects.equals(securityId, orther_.securityId)
        && Objects.equals(securityIdsource, orther_.securityIdsource)
        && Objects.equals(ownerType, orther_.ownerType)
        && Objects.equals(clearingFirm, orther_.clearingFirm)
        && Objects.equals(transactTime, orther_.transactTime)
        && Objects.equals(userInfo, orther_.userInfo)
        && Objects.equals(tradeId, orther_.tradeId)
        && Objects.equals(tradeReportId, orther_.tradeReportId)
        && Objects.equals(tradeReportType, orther_.tradeReportType)
        && Objects.equals(tradeReportTransType, orther_.tradeReportTransType)
        && Objects.equals(tradeHandlingInstr, orther_.tradeHandlingInstr)
        && Objects.equals(lastPx, orther_.lastPx)
        && Objects.equals(lastQty, orther_.lastQty)
        && Objects.equals(trdType, orther_.trdType)
        && Objects.equals(trdSubType, orther_.trdSubType)
        && Objects.equals(confirmId, orther_.confirmId)
        && Objects.equals(execId, orther_.execId)
        && Objects.equals(side, orther_.side)
        && Objects.equals(pbuid, orther_.pbuid)
        && Objects.equals(accountId, orther_.accountId)
        && Objects.equals(branchId, orther_.branchId)
        && Objects.equals(counterPartyPbuid, orther_.counterPartyPbuid)
        && Objects.equals(counterPartyAccountId, orther_.counterPartyAccountId)
        && Objects.equals(counterPartyBranchId, orther_.counterPartyBranchId)
        && Objects.equals(applExtend, orther_.applExtend);
  }

  @Override
  public String toString() {
    return "TradeCaptureCofirm ["
        + "partitionNo="
        + this.partitionNo
        + ", reportIndex="
        + this.reportIndex
        + ", applId="
        + this.applId
        + ", reportingPbuid="
        + this.reportingPbuid
        + ", submittingPbuid="
        + this.submittingPbuid
        + ", securityId="
        + this.securityId
        + ", securityIdsource="
        + this.securityIdsource
        + ", ownerType="
        + this.ownerType
        + ", clearingFirm="
        + this.clearingFirm
        + ", transactTime="
        + this.transactTime
        + ", userInfo="
        + this.userInfo
        + ", tradeId="
        + this.tradeId
        + ", tradeReportId="
        + this.tradeReportId
        + ", tradeReportType="
        + this.tradeReportType
        + ", tradeReportTransType="
        + this.tradeReportTransType
        + ", tradeHandlingInstr="
        + this.tradeHandlingInstr
        + ", lastPx="
        + this.lastPx
        + ", lastQty="
        + this.lastQty
        + ", trdType="
        + this.trdType
        + ", trdSubType="
        + this.trdSubType
        + ", confirmId="
        + this.confirmId
        + ", execId="
        + this.execId
        + ", side="
        + this.side
        + ", pbuid="
        + this.pbuid
        + ", accountId="
        + this.accountId
        + ", branchId="
        + this.branchId
        + ", counterPartyPbuid="
        + this.counterPartyPbuid
        + ", counterPartyAccountId="
        + this.counterPartyAccountId
        + ", counterPartyBranchId="
        + this.counterPartyBranchId
        + ", applExtend="
        + this.applExtend
        + "]";
  }
}
