package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExecRptSync implements BinaryCodec {
  private List<SubExecRptSync> subExecRptSync;

  public List<SubExecRptSync> getSubExecRptSync() {
    return this.subExecRptSync;
  }

  public void setSubExecRptSync(List<SubExecRptSync> subExecRptSync) {
    this.subExecRptSync = subExecRptSync;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (null == this.subExecRptSync || this.subExecRptSync.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShort((short) this.subExecRptSync.size());
      for (int i = 0; i < this.subExecRptSync.size(); i++) {
        this.subExecRptSync.get(i).encode(byteBuf);
      }
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short subExecRptSyncSize = byteBuf.readShort();
    if (subExecRptSyncSize > 0) {
      this.subExecRptSync = new ArrayList<>();
      for (int i = 0; i < subExecRptSyncSize; i++) {
        SubExecRptSync subExecRptSync_ = new SubExecRptSync();
        subExecRptSync_.decode(byteBuf);
        this.subExecRptSync.add(subExecRptSync_);
      }
    }
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
