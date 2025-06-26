package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;

public class RiskControlResponse implements BinaryCodec {
  private String uniqueOrderId;
  private int status;
  private String msg;

  public String getUniqueOrderId() {
    return this.uniqueOrderId;
  }

  public void setUniqueOrderId(String uniqueOrderId) {
    this.uniqueOrderId = uniqueOrderId;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.uniqueOrderId)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.uniqueOrderId.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    byteBuf.writeInt(this.status);
    if (StringUtil.isNullOrEmpty(this.msg)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.msg.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short uniqueOrderIdLen = byteBuf.readShort();
    if (uniqueOrderIdLen > 0) {
      this.uniqueOrderId =
          byteBuf.readCharSequence(uniqueOrderIdLen, StandardCharsets.UTF_8).toString();
    }
    this.status = byteBuf.readInt();
    short msgLen = byteBuf.readShort();
    if (msgLen > 0) {
      this.msg = byteBuf.readCharSequence(msgLen, StandardCharsets.UTF_8).toString();
    }
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    return true;
  }

  @Override
  public String toString() {
    return "";
  }
}
