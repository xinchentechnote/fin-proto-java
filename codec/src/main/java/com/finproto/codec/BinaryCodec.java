package com.finproto.codec;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;

public interface BinaryCodec {

  void encode(ByteBuf byteBuf);

  void decode(ByteBuf byteBuf);

  default void writeFixedString(ByteBuf byteBuf, String value, int len) {
    writeFixedString(byteBuf, value, len, ' ', false);
  }

  default void writeFixedString(
      ByteBuf byteBuf, String value, int len, char padding, boolean fromLeft) {
    int writedLen = 0;
    if (!StringUtil.isNullOrEmpty(value)) {
      byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
      writedLen = Math.min(bytes.length, len);
      if (fromLeft && writedLen < len) {
        padding(byteBuf, len - writedLen, padding);
      }
      byteBuf.writeBytes(bytes, 0, writedLen);
    }
    if (!fromLeft && writedLen < len) {
      padding(byteBuf, len - writedLen, padding);
    }
  }

  private void padding(ByteBuf byteBuf, int len, char pading) {
    while (len > 0) {
      byteBuf.writeByte(pading);
      len--;
    }
  }

  public static String trimByChar(String s, char ch, boolean fromLeft) {
    int len = s.length();
    int start = 0;
    int end = len;

    if (fromLeft) {
      while (start < len && s.charAt(start) == ch) {
        start++;
      }
    } else {
      while (end > 0 && s.charAt(end - 1) == ch) {
        end--;
      }
    }

    return s.substring(start, end);
  }

  default String readFixedString(ByteBuf byteBuf, int len) {
    return readFixedString(byteBuf, len, ' ', false);
  }

  default String readFixedString(ByteBuf byteBuf, int len, char trimPadding, boolean fromLeft) {
    String value = byteBuf.readCharSequence(len, StandardCharsets.UTF_8).toString();
    if (fromLeft) {
      return trimByChar(value, trimPadding, true);
    } else {
      return trimByChar(value, trimPadding, false);
    }
  }
}
