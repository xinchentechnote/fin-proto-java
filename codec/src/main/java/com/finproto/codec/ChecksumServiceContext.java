package com.finproto.codec;

import java.util.HashMap;
import java.util.Map;

public class ChecksumServiceContext {
  private static final Map<String, ChecksumService<?, ?>> CACHE = new HashMap<>();

  static {
    registry(new Crc16ChecksumService());
    registry(new Crc32ChecksumService());
  }

  public static void removeChecksumService(String name) {
    CACHE.remove(name);
  }

  public static void clearAllChecksumService(String name) {
    CACHE.clear();
  }

  public static boolean registry(ChecksumService<?, ?> checksumService) {
    if (CACHE.containsKey(checksumService.algorithm())) {
      return false;
    }
    CACHE.put(checksumService.algorithm(), checksumService);
    return true;
  }

  @SuppressWarnings("unchecked")
  public static <T, R> ChecksumService<T, R> getChecksumService(String name) {
    return (ChecksumService<T, R>) CACHE.get(name);
  }
}
