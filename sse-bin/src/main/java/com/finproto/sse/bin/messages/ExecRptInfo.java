package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExecRptInfo implements BinaryCodec {
  private short platformId;
  private List<String> pbu;
  private List<Integer> setId;

  public short getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(short platformId) {
    this.platformId = platformId;
  }

  public List<String> getPbu() {
    return this.pbu;
  }

  public void setPbu(List<String> pbu) {
    this.pbu = pbu;
  }

  public List<Integer> getSetId() {
    return this.setId;
  }

  public void setSetId(List<Integer> setId) {
    this.setId = setId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.platformId);
    if (null == this.pbu || this.pbu.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShort((short) this.pbu.size());
      for (int i = 0; i < this.pbu.size(); i++) {
        writeFixedString(byteBuf, this.pbu.get(i), 8);
      }
    }
    if (null == this.setId || this.setId.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShort((short) this.setId.size());
      for (int i = 0; i < this.setId.size(); i++) {
        byteBuf.writeInt(this.setId.get(i));
      }
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.platformId = byteBuf.readShort();
    short pbuSize = byteBuf.readShort();
    if (pbuSize > 0) {
      this.pbu = new ArrayList<>();
      for (int i = 0; i < pbuSize; i++) {
        this.pbu.add(readFixedString(byteBuf, 8));
      }
    }
    short setIdSize = byteBuf.readShort();
    if (setIdSize > 0) {
      this.setId = new ArrayList<>();
      for (int i = 0; i < setIdSize; i++) {
        this.setId.add(byteBuf.readInt());
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(platformId, pbu, setId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    ExecRptInfo orther_ = (ExecRptInfo) obj;
    return Objects.equals(platformId, orther_.platformId)
        && Objects.equals(pbu, orther_.pbu)
        && Objects.equals(setId, orther_.setId);
  }

  @Override
  public String toString() {
    return "ExecRptInfo ["
        + "platformId="
        + this.platformId
        + ", pbu="
        + this.pbu
        + ", setId="
        + this.setId
        + "]";
  }
}
