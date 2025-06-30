package com.finproto.sample.messages;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import com.finproto.codec.BinaryCodec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;


public class EmptyPacket implements BinaryCodec {


    @Override
    public void encode(ByteBuf byteBuf) {
    }
    

    @Override
    public void decode(ByteBuf byteBuf) {
    }
    

    @Override
    public int hashCode() {
        return this.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(null == obj || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "EmptyPacket []";}
    

}