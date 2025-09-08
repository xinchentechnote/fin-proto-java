package com.finproto.codec;

import java.util.HashMap;
import java.util.Map;

public enum ChecksumServiceFactory {
  INSTANCE;

  public static ChecksumServiceFactory getInstance() {
    return INSTANCE;
  }

  private final Map<String, ChecksumService<?, ?>> CACHE = new HashMap<>();

  private ChecksumServiceFactory() {
    registry(new Crc16ChecksumService());
    registry(new Crc32ChecksumService());
  }

  public void removeChecksumService(String name) {
    CACHE.remove(name);
  }

  public void clearAllChecksumService() {
    CACHE.clear();
  }

  public boolean registry(ChecksumService<?, ?> checksumService) {
    if (CACHE.containsKey(checksumService.algorithm())) {
      return false;
    }
    CACHE.put(checksumService.algorithm(), checksumService);
    return true;
  }

  @SuppressWarnings("unchecked")
  public <T, R> ChecksumService<T, R> getChecksumService(String name) {
    return (ChecksumService<T, R>) CACHE.get(name);
  }
}
