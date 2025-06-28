package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class ExecutionReport implements BinaryCodec {
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
  private String orderId;
  private String clOrdId;
  private String quoteMsgId;
  private String execId;
  private byte execType;
  private byte ordStatus;
  private long lastPx;
  private long lastQty;
  private long leavesQty;
  private long cumQty;
  private byte side;
  private String accountId;
  private String branchId;
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

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getClOrdId() {
    return this.clOrdId;
  }

  public void setClOrdId(String clOrdId) {
    this.clOrdId = clOrdId;
  }

  public String getQuoteMsgId() {
    return this.quoteMsgId;
  }

  public void setQuoteMsgId(String quoteMsgId) {
    this.quoteMsgId = quoteMsgId;
  }

  public String getExecId() {
    return this.execId;
  }

  public void setExecId(String execId) {
    this.execId = execId;
  }

  public byte getExecType() {
    return this.execType;
  }

  public void setExecType(byte execType) {
    this.execType = execType;
  }

  public byte getOrdStatus() {
    return this.ordStatus;
  }

  public void setOrdStatus(byte ordStatus) {
    this.ordStatus = ordStatus;
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

  public long getLeavesQty() {
    return this.leavesQty;
  }

  public void setLeavesQty(long leavesQty) {
    this.leavesQty = leavesQty;
  }

  public long getCumQty() {
    return this.cumQty;
  }

  public void setCumQty(long cumQty) {
    this.cumQty = cumQty;
  }

  public byte getSide() {
    return this.side;
  }

  public void setSide(byte side) {
    this.side = side;
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

  public BinaryCodec getApplExtend() {
    return this.applExtend;
  }

  public void setApplExtend(BinaryCodec applExtend) {
    this.applExtend = applExtend;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.partitionNo);
    byteBuf.writeLong(this.reportIndex);
    writeFixedString(byteBuf, this.applId, 3);
    writeFixedString(byteBuf, this.reportingPbuid, 6);
    writeFixedString(byteBuf, this.submittingPbuid, 6);
    writeFixedString(byteBuf, this.securityId, 8);
    writeFixedString(byteBuf, this.securityIdsource, 4);
    byteBuf.writeShort(this.ownerType);
    writeFixedString(byteBuf, this.clearingFirm, 2);
    byteBuf.writeLong(this.transactTime);
    writeFixedString(byteBuf, this.userInfo, 8);
    writeFixedString(byteBuf, this.orderId, 16);
    writeFixedString(byteBuf, this.clOrdId, 10);
    writeFixedString(byteBuf, this.quoteMsgId, 10);
    writeFixedString(byteBuf, this.execId, 16);
    byteBuf.writeByte(this.execType);
    byteBuf.writeByte(this.ordStatus);
    byteBuf.writeLong(this.lastPx);
    byteBuf.writeLong(this.lastQty);
    byteBuf.writeLong(this.leavesQty);
    byteBuf.writeLong(this.cumQty);
    byteBuf.writeByte(this.side);
    writeFixedString(byteBuf, this.accountId, 12);
    writeFixedString(byteBuf, this.branchId, 4);
    if (null != this.applExtend) {
      this.applExtend.encode(byteBuf);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.partitionNo = byteBuf.readInt();
    this.reportIndex = byteBuf.readLong();
    this.applId = readFixedString(byteBuf, 3);
    this.reportingPbuid = readFixedString(byteBuf, 6);
    this.submittingPbuid = readFixedString(byteBuf, 6);
    this.securityId = readFixedString(byteBuf, 8);
    this.securityIdsource = readFixedString(byteBuf, 4);
    this.ownerType = byteBuf.readShort();
    this.clearingFirm = readFixedString(byteBuf, 2);
    this.transactTime = byteBuf.readLong();
    this.userInfo = readFixedString(byteBuf, 8);
    this.orderId = readFixedString(byteBuf, 16);
    this.clOrdId = readFixedString(byteBuf, 10);
    this.quoteMsgId = readFixedString(byteBuf, 10);
    this.execId = readFixedString(byteBuf, 16);
    this.execType = byteBuf.readByte();
    this.ordStatus = byteBuf.readByte();
    this.lastPx = byteBuf.readLong();
    this.lastQty = byteBuf.readLong();
    this.leavesQty = byteBuf.readLong();
    this.cumQty = byteBuf.readLong();
    this.side = byteBuf.readByte();
    this.accountId = readFixedString(byteBuf, 12);
    this.branchId = readFixedString(byteBuf, 4);
    this.applExtend = createApplExtend(this.applId);
    this.applExtend.decode(byteBuf);
  }

  private static final Map<String, Supplier<BinaryCodec>> applExtendMap = new HashMap<>();

  static {
    applExtendMap.put("010", Extend200115::new);
    applExtendMap.put("020", Extend200215::new);
    applExtendMap.put("030", Extend200315::new);
    applExtendMap.put("051", Extend200515::new);
    applExtendMap.put("052", Extend200515::new);
    applExtendMap.put("056", Extend200515::new);
    applExtendMap.put("057", Extend200515::new);
    applExtendMap.put("060", Extend200615::new);
    applExtendMap.put("061", Extend200615::new);
    applExtendMap.put("070", Extend200715::new);
    applExtendMap.put("630", Extend206315::new);
    applExtendMap.put("370", Extend203715::new);
    applExtendMap.put("410", Extend204115::new);
    applExtendMap.put("412", Extend204115::new);
    applExtendMap.put("413", Extend204115::new);
    applExtendMap.put("415", Extend204115::new);
    applExtendMap.put("416", Extend204115::new);
    applExtendMap.put("417", Extend204130::new);
    applExtendMap.put("470", Extend204715::new);
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
        orderId,
        clOrdId,
        quoteMsgId,
        execId,
        execType,
        ordStatus,
        lastPx,
        lastQty,
        leavesQty,
        cumQty,
        side,
        accountId,
        branchId,
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
    ExecutionReport orther_ = (ExecutionReport) obj;
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
        && Objects.equals(orderId, orther_.orderId)
        && Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(quoteMsgId, orther_.quoteMsgId)
        && Objects.equals(execId, orther_.execId)
        && Objects.equals(execType, orther_.execType)
        && Objects.equals(ordStatus, orther_.ordStatus)
        && Objects.equals(lastPx, orther_.lastPx)
        && Objects.equals(lastQty, orther_.lastQty)
        && Objects.equals(leavesQty, orther_.leavesQty)
        && Objects.equals(cumQty, orther_.cumQty)
        && Objects.equals(side, orther_.side)
        && Objects.equals(accountId, orther_.accountId)
        && Objects.equals(branchId, orther_.branchId)
        && Objects.equals(applExtend, orther_.applExtend);
  }

  @Override
  public String toString() {
    return "ExecutionReport ["
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
        + ", orderId="
        + this.orderId
        + ", clOrdId="
        + this.clOrdId
        + ", quoteMsgId="
        + this.quoteMsgId
        + ", execId="
        + this.execId
        + ", execType="
        + this.execType
        + ", ordStatus="
        + this.ordStatus
        + ", lastPx="
        + this.lastPx
        + ", lastQty="
        + this.lastQty
        + ", leavesQty="
        + this.leavesQty
        + ", cumQty="
        + this.cumQty
        + ", side="
        + this.side
        + ", accountId="
        + this.accountId
        + ", branchId="
        + this.branchId
        + ", applExtend="
        + this.applExtend
        + "]";
  }
}
