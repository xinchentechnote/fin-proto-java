package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ReportFinished implements BinaryCodec {
  private int partitionNo;
  private long reportIndex;
  private short platformId;

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

  public short getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(short platformId) {
    this.platformId = platformId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.partitionNo);
    byteBuf.writeLong(this.reportIndex);
    byteBuf.writeShort(this.platformId);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.partitionNo = byteBuf.readInt();
    this.reportIndex = byteBuf.readLong();
    this.platformId = byteBuf.readShort();
  }

  @Override
  public int hashCode() {
    return Objects.hash(partitionNo, reportIndex, platformId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ReportFinished orther_ = (ReportFinished) obj;
    return Objects.equals(partitionNo, orther_.partitionNo)
        && Objects.equals(reportIndex, orther_.reportIndex)
        && Objects.equals(platformId, orther_.platformId);
  }

  @Override
  public String toString() {
    return "ReportFinished ["
        + "partitionNo="
        + this.partitionNo
        + ", reportIndex="
        + this.reportIndex
        + ", platformId="
        + this.platformId
        + "]";
  }
}
