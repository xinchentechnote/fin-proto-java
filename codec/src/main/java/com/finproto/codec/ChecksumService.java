package com.finproto.codec;

import java.util.Objects;

public interface ChecksumService<T, R> {

  /**
   * calc ByteBuffer checksum
   *
   * @param buffer bytebuf
   * @return checksum
   */
  R calc(T buffer);

  /**
   * verify
   *
   * @param buffer bytebuf
   * @param expectedChecksum
   * @return true or false
   */
  default boolean verify(T buffer, R expectedChecksum) {
    return Objects.equals(calc(buffer), expectedChecksum);
  }

  /**
   * checksum algorithm name
   *
   * @return algorithm name: "sseBinCheckSum", "crc32" and so no.
   */
  String algorithm();
}
