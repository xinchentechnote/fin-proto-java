// Code generated by fin-protoc. DO NOT EDIT.
package com.finproto.risk.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class OrderConfirm implements BinaryCodec {
  private String clOrdId;
  private String execType;
  private int ordRejReason;
  private String ordCnfmId;

  public String getClOrdId() {
    return this.clOrdId;
  }

  public void setClOrdId(String clOrdId) {
    this.clOrdId = clOrdId;
  }

  public String getExecType() {
    return this.execType;
  }

  public void setExecType(String execType) {
    this.execType = execType;
  }

  public int getOrdRejReason() {
    return this.ordRejReason;
  }

  public void setOrdRejReason(int ordRejReason) {
    this.ordRejReason = ordRejReason;
  }

  public String getOrdCnfmId() {
    return this.ordCnfmId;
  }

  public void setOrdCnfmId(String ordCnfmId) {
    this.ordCnfmId = ordCnfmId;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.clOrdId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.clOrdId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    writeFixedString(byteBuf, this.execType, 1);
    byteBuf.writeInt(this.ordRejReason);
    if (StringUtil.isNullOrEmpty(this.ordCnfmId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.ordCnfmId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    int clOrdIdLen = byteBuf.readInt();
    if (clOrdIdLen > 0) {
      this.clOrdId = byteBuf.readCharSequence(clOrdIdLen, StandardCharsets.UTF_8).toString();
    }
    this.execType = readFixedString(byteBuf, 1);
    this.ordRejReason = byteBuf.readInt();
    int ordCnfmIdLen = byteBuf.readInt();
    if (ordCnfmIdLen > 0) {
      this.ordCnfmId = byteBuf.readCharSequence(ordCnfmIdLen, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(clOrdId, execType, ordRejReason, ordCnfmId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    OrderConfirm orther_ = (OrderConfirm) obj;
    return Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(execType, orther_.execType)
        && Objects.equals(ordRejReason, orther_.ordRejReason)
        && Objects.equals(ordCnfmId, orther_.ordCnfmId);
  }

  @Override
  public String toString() {
    return "OrderConfirm ["
        + "clOrdId="
        + this.clOrdId
        + ", execType="
        + this.execType
        + ", ordRejReason="
        + this.ordRejReason
        + ", ordCnfmId="
        + this.ordCnfmId
        + "]";
  }
}
