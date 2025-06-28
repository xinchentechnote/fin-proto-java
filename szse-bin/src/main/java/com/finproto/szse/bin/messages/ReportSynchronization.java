package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ReportSynchronization implements BinaryCodec {
  private int noPartitions;
  private PartitionReport partitionReport;

  public int getNoPartitions() {
    return this.noPartitions;
  }

  public void setNoPartitions(int noPartitions) {
    this.noPartitions = noPartitions;
  }

  public PartitionReport getPartitionReport() {
    return this.partitionReport;
  }

  public void setPartitionReport(PartitionReport partitionReport) {
    this.partitionReport = partitionReport;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.noPartitions);
    if (null == this.partitionReport) {
      this.partitionReport = new PartitionReport();
    }
    this.partitionReport.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.noPartitions = byteBuf.readInt();
    if (null == this.partitionReport) {
      this.partitionReport = new PartitionReport();
    }
    this.partitionReport.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noPartitions, partitionReport);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ReportSynchronization orther_ = (ReportSynchronization) obj;
    return Objects.equals(noPartitions, orther_.noPartitions)
        && Objects.equals(partitionReport, orther_.partitionReport);
  }

  @Override
  public String toString() {
    return "ReportSynchronization ["
        + "noPartitions="
        + this.noPartitions
        + ", partitionReport="
        + this.partitionReport
        + "]";
  }
}
