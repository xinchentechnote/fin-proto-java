package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NestedPacket implements BinaryCodec {
  private List<SubPacket> subPacket;
  private InerPacket inerPacket;

  public List<SubPacket> getSubPacket() {
    return this.subPacket;
  }

  public void setSubPacket(List<SubPacket> subPacket) {
    this.subPacket = subPacket;
  }

  public InerPacket getInerPacket() {
    return this.inerPacket;
  }

  public void setInerPacket(InerPacket inerPacket) {
    this.inerPacket = inerPacket;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (null == this.subPacket || this.subPacket.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShortLE((short) this.subPacket.size());
      for (int i = 0; i < this.subPacket.size(); i++) {
        this.subPacket.get(i).encode(byteBuf);
      }
    }
    this.inerPacket.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short subPacketSize = byteBuf.readShortLE();
    if (subPacketSize > 0) {
      this.subPacket = new ArrayList<>();
      for (int i = 0; i < subPacketSize; i++) {
        SubPacket subPacket_ = new SubPacket();
        subPacket_.decode(byteBuf);
        this.subPacket.add(subPacket_);
      }
    }
    if (null == this.inerPacket) {
      this.inerPacket = new InerPacket();
    }
    this.inerPacket.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subPacket, inerPacket);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    NestedPacket orther_ = (NestedPacket) obj;
    return Objects.equals(subPacket, orther_.subPacket)
        && Objects.equals(inerPacket, orther_.inerPacket);
  }

  @Override
  public String toString() {
    return "NestedPacket ["
        + "subPacket="
        + this.subPacket
        + ", inerPacket="
        + this.inerPacket
        + "]";
  }

  public static class InerPacket implements BinaryCodec {
    private int fieldU32;
    private List<Short> fieldI16List;

    public int getFieldU32() {
      return this.fieldU32;
    }

    public void setFieldU32(int fieldU32) {
      this.fieldU32 = fieldU32;
    }

    public List<Short> getFieldI16List() {
      return this.fieldI16List;
    }

    public void setFieldI16List(List<Short> fieldI16List) {
      this.fieldI16List = fieldI16List;
    }

    @Override
    public void encode(ByteBuf byteBuf) {
      byteBuf.writeIntLE(this.fieldU32);
      if (null == this.fieldI16List || this.fieldI16List.size() == 0) {
        byteBuf.writeShort(0);
      } else {
        byteBuf.writeShortLE((short) this.fieldI16List.size());
        for (int i = 0; i < this.fieldI16List.size(); i++) {
          byteBuf.writeShortLE(this.fieldI16List.get(i));
        }
      }
    }

    @Override
    public void decode(ByteBuf byteBuf) {
      this.fieldU32 = byteBuf.readIntLE();
      short fieldI16ListSize = byteBuf.readShortLE();
      if (fieldI16ListSize > 0) {
        this.fieldI16List = new ArrayList<>();
        for (int i = 0; i < fieldI16ListSize; i++) {
          this.fieldI16List.add(byteBuf.readShortLE());
        }
      }
    }

    @Override
    public int hashCode() {
      return Objects.hash(fieldU32, fieldI16List);
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (null == obj || getClass() != obj.getClass()) {
        return false;
      }
      InerPacket orther_ = (InerPacket) obj;
      return Objects.equals(fieldU32, orther_.fieldU32)
          && Objects.equals(fieldI16List, orther_.fieldI16List);
    }

    @Override
    public String toString() {
      return "InerPacket ["
          + "fieldU32="
          + this.fieldU32
          + ", fieldI16List="
          + this.fieldI16List
          + "]";
    }
  }
}
