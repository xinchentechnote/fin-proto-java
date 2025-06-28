package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class PartitionReport implements BinaryCodec {
  private int partitionNo;
  private long reportIndex;

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

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.partitionNo);
    byteBuf.writeLong(this.reportIndex);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.partitionNo = byteBuf.readInt();
    this.reportIndex = byteBuf.readLong();
  }

  @Override
  public int hashCode() {
    return Objects.hash(partitionNo, reportIndex);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    PartitionReport orther_ = (PartitionReport) obj;
    return Objects.equals(partitionNo, orther_.partitionNo)
        && Objects.equals(reportIndex, orther_.reportIndex);
  }

  @Override
  public String toString() {
    return "PartitionReport ["
        + "partitionNo="
        + this.partitionNo
        + ", reportIndex="
        + this.reportIndex
        + "]";
  }
}
