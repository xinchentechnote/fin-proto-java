package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Extend101601 implements BinaryCodec {
  private String contractAccountCode;

  public String getContractAccountCode() {
    return this.contractAccountCode;
  }

  public void setContractAccountCode(String contractAccountCode) {
    this.contractAccountCode = contractAccountCode;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    writeFixedString(byteBuf, this.contractAccountCode, 6);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.contractAccountCode = readFixedString(byteBuf, 6);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractAccountCode);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Extend101601 orther_ = (Extend101601) obj;
    return Objects.equals(contractAccountCode, orther_.contractAccountCode);
  }

  @Override
  public String toString() {
    return "Extend101601 [" + "contractAccountCode=" + this.contractAccountCode + "]";
  }
}
