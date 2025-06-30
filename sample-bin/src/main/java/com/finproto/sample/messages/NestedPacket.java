package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NestedPacket implements BinaryCodec {
  private SubPacket subPacket;
  private List<SubPacket> subPacketList;
  private InerPacket inerPacket;

  public SubPacket getSubPacket() {
    return this.subPacket;
  }

  public void setSubPacket(SubPacket subPacket) {
    this.subPacket = subPacket;
  }

  public List<SubPacket> getSubPacketList() {
    return this.subPacketList;
  }

  public void setSubPacketList(List<SubPacket> subPacketList) {
    this.subPacketList = subPacketList;
  }

  public InerPacket getInerPacket() {
    return this.inerPacket;
  }

  public void setInerPacket(InerPacket inerPacket) {
    this.inerPacket = inerPacket;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    this.subPacket.encode(byteBuf);
    if (null == this.subPacketList || this.subPacketList.size() == 0) {
      byteBuf.writeShort(0);
    } else {
      byteBuf.writeShortLE((short) this.subPacketList.size());
      for (int i = 0; i < this.subPacketList.size(); i++) {
        this.subPacketList.get(i).encode(byteBuf);
      }
    }
    this.inerPacket.encode(byteBuf);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    if (null == this.subPacket) {
      this.subPacket = new SubPacket();
    }
    this.subPacket.decode(byteBuf);
    short subPacketListSize = byteBuf.readShortLE();
    if (subPacketListSize > 0) {
      this.subPacketList = new ArrayList<>();
      for (int i = 0; i < subPacketListSize; i++) {
        SubPacket subPacketList_ = new SubPacket();
        subPacketList_.decode(byteBuf);
        this.subPacketList.add(subPacketList_);
      }
    }
    if (null == this.inerPacket) {
      this.inerPacket = new InerPacket();
    }
    this.inerPacket.decode(byteBuf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subPacket, subPacketList, inerPacket);
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
        && Objects.equals(subPacketList, orther_.subPacketList)
        && Objects.equals(inerPacket, orther_.inerPacket);
  }

  @Override
  public String toString() {
    return "NestedPacket ["
        + "subPacket="
        + this.subPacket
        + ", subPacketList="
        + this.subPacketList
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
