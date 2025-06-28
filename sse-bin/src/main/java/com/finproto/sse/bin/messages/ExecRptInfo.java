package com.finproto.sse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class ExecRptInfo implements BinaryCodec {
  private short platformId;
  private String pbu;
  private int setId;

  public short getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(short platformId) {
    this.platformId = platformId;
  }

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

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.platformId);
    writeFixedString(byteBuf, this.pbu, 8);
    byteBuf.writeInt(this.setId);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.platformId = byteBuf.readShort();
    this.pbu = readFixedString(byteBuf, 8);
    this.setId = byteBuf.readInt();
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
