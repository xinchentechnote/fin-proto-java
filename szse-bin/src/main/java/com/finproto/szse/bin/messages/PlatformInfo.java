package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class PlatformInfo implements BinaryCodec {
  private short platformId;
  private int noPartitions;
  private PlatformPartition platformPartition;

  public short getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(short platformId) {
    this.platformId = platformId;
  }

  public int getNoPartitions() {
    return this.noPartitions;
  }

  public void setNoPartitions(int noPartitions) {
    this.noPartitions = noPartitions;
  }

  public PlatformPartition getPlatformPartition() {
    return this.platformPartition;
  }

  public void setPlatformPartition(PlatformPartition platformPartition) {
    this.platformPartition = platformPartition;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.platformId);
    byteBuf.writeInt(this.noPartitions);
    if (null == this.platformPartition) {
      this.platformPartition = new PlatformPartition();
    }
    this.platformPartition.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.platformId = byteBuf.readShort();
    this.noPartitions = byteBuf.readInt();
    if (null == this.platformPartition) {
      this.platformPartition = new PlatformPartition();
    }
    this.platformPartition.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(platformId, noPartitions, platformPartition);
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
        && Objects.equals(noPartitions, orther_.noPartitions)
        && Objects.equals(platformPartition, orther_.platformPartition);
  }

  @Override
  public String toString() {
    return "PlatformInfo ["
        + "platformId="
        + this.platformId
        + ", noPartitions="
        + this.noPartitions
        + ", platformPartition="
        + this.platformPartition
        + "]";
  }
}
