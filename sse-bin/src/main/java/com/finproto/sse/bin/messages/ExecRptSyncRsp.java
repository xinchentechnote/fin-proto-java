package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ExecRptSyncRsp implements BinaryCodec {
  private SubExecRptSyncRsp subExecRptSyncRsp;

  public SubExecRptSyncRsp getSubExecRptSyncRsp() {
    return this.subExecRptSyncRsp;
  }

  public void setSubExecRptSyncRsp(SubExecRptSyncRsp subExecRptSyncRsp) {
    this.subExecRptSyncRsp = subExecRptSyncRsp;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (null == this.subExecRptSyncRsp) {
      this.subExecRptSyncRsp = new SubExecRptSyncRsp();
    }
    this.subExecRptSyncRsp.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    if (null == this.subExecRptSyncRsp) {
      this.subExecRptSyncRsp = new SubExecRptSyncRsp();
    }
    this.subExecRptSyncRsp.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subExecRptSyncRsp);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ExecRptSyncRsp orther_ = (ExecRptSyncRsp) obj;
    return Objects.equals(subExecRptSyncRsp, orther_.subExecRptSyncRsp);
  }

  @Override
  public String toString() {
    return "ExecRptSyncRsp [" + "subExecRptSyncRsp=" + this.subExecRptSyncRsp + "]";
  }

  public static class SubExecRptSyncRsp implements BinaryCodec {
    private String pbu;
    private int setId;
    private long beginReportIndex;
    private long endReportIndex;
    private int rejReason;
    private String text;

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

    public long getEndReportIndex() {
      return this.endReportIndex;
    }

    public void setEndReportIndex(long endReportIndex) {
      this.endReportIndex = endReportIndex;
    }

    public int getRejReason() {
      return this.rejReason;
    }

    public void setRejReason(int rejReason) {
      this.rejReason = rejReason;
    }

    public String getText() {
      return this.text;
    }

    public void setText(String text) {
      this.text = text;
    }

    @Override
    public void encode(ByteBuf byteBuf) {
      writeFixedString(byteBuf, this.pbu, 8);
      byteBuf.writeInt(this.setId);
      byteBuf.writeLong(this.beginReportIndex);
      byteBuf.writeLong(this.endReportIndex);
      byteBuf.writeInt(this.rejReason);
      writeFixedString(byteBuf, this.text, 64);
    }

    @Override
    public void decode(ByteBuf byteBuf) {
      this.pbu = readFixedString(byteBuf, 8);
      this.setId = byteBuf.readInt();
      this.beginReportIndex = byteBuf.readLong();
      this.endReportIndex = byteBuf.readLong();
      this.rejReason = byteBuf.readInt();
      this.text = readFixedString(byteBuf, 64);
    }

    @Override
    public int hashCode() {
      return Objects.hash(pbu, setId, beginReportIndex, endReportIndex, rejReason, text);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (null == obj || getClass() != obj.getClass()) {
        return false;
      }
      SubExecRptSyncRsp orther_ = (SubExecRptSyncRsp) obj;
      return Objects.equals(pbu, orther_.pbu)
          && Objects.equals(setId, orther_.setId)
          && Objects.equals(beginReportIndex, orther_.beginReportIndex)
          && Objects.equals(endReportIndex, orther_.endReportIndex)
          && Objects.equals(rejReason, orther_.rejReason)
          && Objects.equals(text, orther_.text);
    }

    @Override
    public String toString() {
      return "SubExecRptSyncRsp ["
          + "pbu="
          + this.pbu
          + ", setId="
          + this.setId
          + ", beginReportIndex="
          + this.beginReportIndex
          + ", endReportIndex="
          + this.endReportIndex
          + ", rejReason="
          + this.rejReason
          + ", text="
          + this.text
          + "]";
    }
  }
}
