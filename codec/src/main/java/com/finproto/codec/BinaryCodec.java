package com.finproto.codec;

import io.netty.buffer.ByteBuf;

public interface BinaryCodec {
    void encode(ByteBuf byteBuf);
    void decode(ByteBuf byteBuf);
}
