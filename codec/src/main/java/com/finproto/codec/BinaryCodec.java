package com.finproto.codec;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;

public interface BinaryCodec {

    void encode(ByteBuf byteBuf);

    void decode(ByteBuf byteBuf);

    default void writeFixedString(ByteBuf byteBuf, String value, int len) {
        int writedLen = 0;
        if (!StringUtil.isNullOrEmpty(value)) {
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
            writedLen = Math.min(bytes.length, len);
            byteBuf.writeBytes(bytes, 0, writedLen);
        }
        while (writedLen < len) {
            byteBuf.writeByte(0);
            writedLen++;
        }
    }

    default String readFixedString(ByteBuf byteBuf, int len) {
        return byteBuf.readCharSequence(len, StandardCharsets.UTF_8).toString().trim();
    }
}
