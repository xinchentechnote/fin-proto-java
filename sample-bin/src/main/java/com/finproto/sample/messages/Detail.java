package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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
      byteBuf.writeShortLE(bytes.length);
      byteBuf.writeBytes(bytes);
    }

    byteBuf.writeShortLE(this.code);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    short ruleNameLen = byteBuf.readShortLE();
    if (ruleNameLen > 0) {
      this.ruleName = byteBuf.readCharSequence(ruleNameLen, StandardCharsets.UTF_8).toString();
    }
    this.code = byteBuf.readShortLE();
  }

  @Override
  public int hashCode() {
    return Objects.hash(ruleName, code);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Detail detail = (Detail) obj;
    return Objects.equals(ruleName, detail.ruleName) && Objects.equals(code, detail.code);
  }

  @Override
  public String toString() {
    return "Detail [" + "ruleName=" + this.ruleName + ", code=" + this.code + "]";
  }
}
