package com.bruno.shoppingjava.shared.infrastructure.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public abstract class ShoppingCacheManager<K, V> {
  private final Cache<K, V> cache;

  protected ShoppingCacheManager() {
    this.cache = Caffeine.newBuilder()
      .expireAfterWrite(Duration.ofHours(12))
      .maximumSize(1000)
      .evictionListener((key, item, cause) -> LOGGER.info("Key {} was evicted. Cause: {}. Item: {}", key, cause, item))
      .removalListener((key, item, cause) -> LOGGER.info("Key {} was removed. Cause: {}. Item: {}", key, cause, item))
      .build();
  }

  public V get(K key, Function<K, V> handler) {
    return this.cache.get(key, handler);
  }

  public Optional<V> getIfPresent(K key) {
    return Optional.ofNullable(this.cache.getIfPresent(key));
  }

  protected V put(K key, V object) {
    if (object instanceof Throwable error) {
      LOGGER.error("Cannot get value from cache for key: {}", key, error);
      throw new IllegalArgumentException("Error retrieving value from cache: " + error.getMessage(), error);
    }
    this.cache.put(key, object);
    return object;
  }

  protected void remove(K key) {
    this.cache.invalidate(key);
  }

  public void clear() {
    LOGGER.info("Clearing cache");
    this.cache.invalidateAll();
  }

  public long getCacheSize() {
    return this.cache.estimatedSize();
  }
}
