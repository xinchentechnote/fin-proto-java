package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ExecRptSync implements BinaryCodec {
  private SubExecRptSync subExecRptSync;

  public SubExecRptSync getSubExecRptSync() {
    return this.subExecRptSync;
  }

  public void setSubExecRptSync(SubExecRptSync subExecRptSync) {
    this.subExecRptSync = subExecRptSync;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (null == this.subExecRptSync) {
      this.subExecRptSync = new SubExecRptSync();
    }
    this.subExecRptSync.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    if (null == this.subExecRptSync) {
      this.subExecRptSync = new SubExecRptSync();
    }
    this.subExecRptSync.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subExecRptSync);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ExecRptSync orther_ = (ExecRptSync) obj;
    return Objects.equals(subExecRptSync, orther_.subExecRptSync);
  }

  @Override
  public String toString() {
    return "ExecRptSync [" + "subExecRptSync=" + this.subExecRptSync + "]";
  }

  public static class SubExecRptSync implements BinaryCodec {
    private String pbu;
    private int setId;
    private long beginReportIndex;

    public String getPbu() {
      return this.pbu;
    }

    public void setPbu(String pbu) {
      this.pbu = pbu;
    }

    public int getSetId() {
      return this.setId;
    }

    public void setSetId(int setId) {
      this.setId = setId;
    }

    public long getBeginReportIndex() {
      return this.beginReportIndex;
    }

    public void setBeginReportIndex(long beginReportIndex) {
      this.beginReportIndex = beginReportIndex;
    }

    @Override
    public void encode(ByteBuf byteBuf) {
      writeFixedString(byteBuf, this.pbu, 8);
      byteBuf.writeInt(this.setId);
      byteBuf.writeLong(this.beginReportIndex);
    }

    @Override
    public void decode(ByteBuf byteBuf) {
      this.pbu = readFixedString(byteBuf, 8);
      this.setId = byteBuf.readInt();
      this.beginReportIndex = byteBuf.readLong();
    }

    @Override
    public int hashCode() {
      return Objects.hash(pbu, setId, beginReportIndex);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (null == obj || getClass() != obj.getClass()) {
        return false;
      }
      SubExecRptSync orther_ = (SubExecRptSync) obj;
      return Objects.equals(pbu, orther_.pbu)
          && Objects.equals(setId, orther_.setId)
          && Objects.equals(beginReportIndex, orther_.beginReportIndex);
    }

    @Override
    public String toString() {
      return "SubExecRptSync ["
          + "pbu="
          + this.pbu
          + ", setId="
          + this.setId
          + ", beginReportIndex="
          + this.beginReportIndex
          + "]";
    }
  }
}
