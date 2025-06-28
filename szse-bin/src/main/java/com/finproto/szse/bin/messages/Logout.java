package com.finproto.szse.bin.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;

public class Logout implements BinaryCodec {
  private int sessionStatus;
  private String text;

  public int getSessionStatus() {
    return this.sessionStatus;
  }

  public void setSessionStatus(int sessionStatus) {
    this.sessionStatus = sessionStatus;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeInt(this.sessionStatus);
    writeFixedString(byteBuf, this.text, 200);
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.sessionStatus = byteBuf.readInt();
    this.text = readFixedString(byteBuf, 200);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionStatus, text);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj || getClass() != obj.getClass()) {
      return false;
    }
    Logout orther_ = (Logout) obj;
    return Objects.equals(sessionStatus, orther_.sessionStatus)
        && Objects.equals(text, orther_.text);
  }

  @Override
  public String toString() {
    return "Logout [" + "sessionStatus=" + this.sessionStatus + ", text=" + this.text + "]";
  }
}
