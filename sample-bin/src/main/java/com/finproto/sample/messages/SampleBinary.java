package com.finproto.sample.messages;
import java.nio.charset.StandardCharsets;

import com.finproto.codec.BinaryCodec;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;

public class SampleBinary implements BinaryCodec {
    private short msgType;
    private short bodyLength;
    private BinaryCodec msgTypeBody;

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
    
    public BinaryCodec getMsgTypeBody() {
        return this.msgTypeBody;
    }
    
    
    public void setMsgTypeBody(BinaryCodec msgTypeBody) {
        this.msgTypeBody = msgTypeBody;
    }
    

    @Override
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeShort(this.msgType);
        byteBuf.writeShort(this.bodyLength);
        if (null != this.msgTypeBody) {
        this.msgTypeBody.encode(byteBuf);}
    }
    

    @Override
    public void decode(ByteBuf byteBuf) {
        this.msgType = byteBuf.readShort();
        this.bodyLength = byteBuf.readShort();
        this.msgTypeBody = createMsgTypeBody(this.msgType);
        this.msgTypeBody.decode(byteBuf);
    }
    
    private BinaryCodec createMsgTypeBody(short msgType) {
        return null;
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