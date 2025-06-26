package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;

public class Detail implements BinaryCodec {
  private String ruleName;
  private short code;

  public String getRuleName() {
    return this.ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public short getCode() {
    return this.code;
  }

  public void setCode(short code) {
    this.code = code;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    if (StringUtil.isNullOrEmpty(this.ruleName)) {
      byteBuf.writeShort(0);
    } else {
      byte[] bytes = this.ruleName.getBytes(StandardCharsets.UTF_8);
      byteBuf.writeShort(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    byteBuf.writeShort(this.code);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short ruleNameLen = byteBuf.readShort();
    if (ruleNameLen > 0) {
      this.ruleName = byteBuf.readCharSequence(ruleNameLen, StandardCharsets.UTF_8).toString();
    }
    this.code = byteBuf.readShort();
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
