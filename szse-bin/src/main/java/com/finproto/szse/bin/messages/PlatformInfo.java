package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlatformInfo implements BinaryCodec {
  private short platformId;
  private List<PlatformPartition> platformPartition;

  public short getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(short platformId) {
    this.platformId = platformId;
  }

  public List<PlatformPartition> getPlatformPartition() {
    return this.platformPartition;
  }

  public void setPlatformPartition(List<PlatformPartition> platformPartition) {
    this.platformPartition = platformPartition;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.platformId);
    if (null == this.platformPartition || this.platformPartition.size() == 0) {
      byteBuf.writeInt(0);
    } else {
      byteBuf.writeInt((int) this.platformPartition.size());
      for (int i = 0; i < this.platformPartition.size(); i++) {
        this.platformPartition.get(i).encode(byteBuf);
      }
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.platformId = byteBuf.readShort();
    int platformPartitionSize = byteBuf.readInt();
    if (platformPartitionSize > 0) {
      this.platformPartition = new ArrayList<>();
      for (int i = 0; i < platformPartitionSize; i++) {
        PlatformPartition platformPartition_ = new PlatformPartition();
        platformPartition_.decode(byteBuf);
        this.platformPartition.add(platformPartition_);
      }
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(platformId, platformPartition);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    PlatformInfo orther_ = (PlatformInfo) obj;
    return Objects.equals(platformId, orther_.platformId)
        && Objects.equals(platformPartition, orther_.platformPartition);
  }

  @Override
  public String toString() {
    return "PlatformInfo ["
        + "platformId="
        + this.platformId
        + ", platformPartition="
        + this.platformPartition
        + "]";
  }
}
