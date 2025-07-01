package com.finproto.risk.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class OrderCancel implements BinaryCodec {
  private String clOrdId;
  private String origClOrdId;
  private String securityId;

  public String getClOrdId() {
    return this.clOrdId;
  }

  public void setClOrdId(String clOrdId) {
    this.clOrdId = clOrdId;
  }

  public String getOrigClOrdId() {
    return this.origClOrdId;
  }

  public void setOrigClOrdId(String origClOrdId) {
    this.origClOrdId = origClOrdId;
  }

  public String getSecurityId() {
    return this.securityId;
  }

  public void setSecurityId(String securityId) {
    this.securityId = securityId;
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

    if (StringUtil.isNullOrEmpty(this.origClOrdId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.origClOrdId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeInt(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    if (StringUtil.isNullOrEmpty(this.securityId)) {
      byteBuf.writeInt(0);
    } else {
      byte[] bytes = this.securityId.getBytes(StandardCharsets.UTF_8);
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
    int origClOrdIdLen = byteBuf.readInt();
    if (origClOrdIdLen > 0) {
      this.origClOrdId =
          byteBuf.readCharSequence(origClOrdIdLen, StandardCharsets.UTF_8).toString();
    }
    int securityIdLen = byteBuf.readInt();
    if (securityIdLen > 0) {
      this.securityId = byteBuf.readCharSequence(securityIdLen, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(clOrdId, origClOrdId, securityId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    OrderCancel orther_ = (OrderCancel) obj;
    return Objects.equals(clOrdId, orther_.clOrdId)
        && Objects.equals(origClOrdId, orther_.origClOrdId)
        && Objects.equals(securityId, orther_.securityId);
  }

  @Override
  public String toString() {
    return "OrderCancel ["
        + "clOrdId="
        + this.clOrdId
        + ", origClOrdId="
        + this.origClOrdId
        + ", securityId="
        + this.securityId
        + "]";
  }
}
