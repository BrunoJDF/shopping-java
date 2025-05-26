package com.bruno.shoppingjava.client.infrastructure.cache;

import com.bruno.shoppingjava.client.domain.ClientMother;
import com.bruno.shoppingjava.product.ProductUnitTestCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientCacheManagerTest extends ProductUnitTestCase {

  @InjectMocks
  private ClientCacheManager systemUnderTest;

  @Test
  void shouldBeInstantiated() {
    assertNotNull(systemUnderTest);
  }

  @Test
  void shouldGetCache() {
    // Given
    systemUnderTest.put(1L, ClientMother.random());

    // When
    var cacheSize = systemUnderTest.getCacheSize();

    // Then
    assertEquals(1, cacheSize);
  }

  @Test
  void shouldGetClientFromCache() {
    // Given
    var client = ClientMother.random();
    systemUnderTest.put(client.getId(), client);

    // When
    var cachedClient = systemUnderTest.getIfPresent(client.getId())
      .orElseThrow();

    // Then
    assertEquals(client, cachedClient);
  }

  @Test
  void shouldRemoveClientFromCache() {
    // Given
    var client = ClientMother.random();
    systemUnderTest.put(client.getId(), client);

    // When
    systemUnderTest.remove(client.getId());

    // Then
    assertFalse(systemUnderTest.getIfPresent(client.getId()).isPresent());
  }

  @Test
  void shouldClearCache() {
    // Given
    systemUnderTest.put(1L, ClientMother.random());
    systemUnderTest.put(2L, ClientMother.random());

    // When
    systemUnderTest.clear();

    // Then
    assertEquals(0, systemUnderTest.getCacheSize());
  }
}
