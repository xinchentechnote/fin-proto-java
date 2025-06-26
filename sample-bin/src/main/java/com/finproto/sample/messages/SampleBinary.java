package com.finproto.sample.messages;

import com.finproto.codec.BinaryCodec;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SampleBinary implements BinaryCodec {
  private short msgType;
  private short bodyLength;
  private BinaryCodec body;

  public short getMsgType() {
    return this.msgType;
  }

  public void setMsgType(short msgType) {
    this.msgType = msgType;
  }

  public short getBodyLength() {
    return this.bodyLength;
  }

  public void setBodyLength(short bodyLength) {
    this.bodyLength = bodyLength;
  }

  public BinaryCodec getBody() {
    return this.body;
  }

  public void setBody(BinaryCodec body) {
    this.body = body;
  }

  @Override
  public void encode(ByteBuf byteBuf) {
    byteBuf.writeShort(this.msgType);
    byteBuf.writeShort(this.bodyLength);
    if (null != this.body) {
      this.body.encode(byteBuf);
    }
  }

  @Override
  public void decode(ByteBuf byteBuf) {
    this.msgType = byteBuf.readShort();
    this.bodyLength = byteBuf.readShort();
    this.body = createBody(this.msgType);
    this.body.decode(byteBuf);
  }

  private static final Map<Short, Supplier<BinaryCodec>> bodyMap = new HashMap<>();

  static {
    bodyMap.put((short) 4, RiskControlRequest::new);
    bodyMap.put((short) 5, RiskControlResponse::new);
  }

  private BinaryCodec createBody(short msgType) {
    Supplier<BinaryCodec> supplier = bodyMap.get(msgType);
    if (null == supplier) {
      throw new IllegalArgumentException("Unsupported MsgType:" + msgType);
    }
    return supplier.get();
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
