package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReportSynchronization implements BinaryCodec {
  private List<PartitionReport> partitionReport;

  public List<PartitionReport> getPartitionReport() {
    return this.partitionReport;
  }

  public void setPartitionReport(List<PartitionReport> partitionReport) {
    this.partitionReport = partitionReport;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (null == this.partitionReport || this.partitionReport.size() == 0) {
      byteBuf.writeInt(0);
    } else {
      byteBuf.writeInt((int) this.partitionReport.size());
      for (int i = 0; i < this.partitionReport.size(); i++) {
        this.partitionReport.get(i).encode(byteBuf);
      }
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    int partitionReportSize = byteBuf.readInt();
    if (partitionReportSize > 0) {
      this.partitionReport = new ArrayList<>();
      for (int i = 0; i < partitionReportSize; i++) {
        PartitionReport partitionReport_ = new PartitionReport();
        partitionReport_.decode(byteBuf);
        this.partitionReport.add(partitionReport_);
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(partitionReport);
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
    return Objects.equals(partitionReport, orther_.partitionReport);
  }

  @Override
  public String toString() {
    return "ReportSynchronization [" + "partitionReport=" + this.partitionReport + "]";
  }
}
