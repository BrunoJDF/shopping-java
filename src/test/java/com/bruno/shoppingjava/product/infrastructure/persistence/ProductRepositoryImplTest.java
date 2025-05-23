package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAOMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ProductRepositoryImplTest extends ProductUnitTestCase {

  @InjectMocks
  private ProductRepositoryImpl systemUnderTest;

  @Mock
  private CrudProductRepository repository;

  @Test
  void getAll() {
    // Given
    var products = ProductDAOMother.randomList();
    // When
    when(repository.findAll())
      .thenReturn(products);

    var res = systemUnderTest.getAll();
    // Then

    assertEquals(products.size(), res.size());
  }

  @Test
  void save() {
    // Given
    var product = ProductDAOMother.random();

    // When
    when(repository.save(product))
      .thenReturn(product);
    var res = systemUnderTest.save(product.toDomain());

    // Then
    assertEquals(product.toDomain(), res);
  }

  @Test
  void findById() {
    // Given
    var product = ProductDAOMother.random();

    // When
    when(repository.findById(product.getId()))
      .thenReturn(java.util.Optional.of(product));
    var res = systemUnderTest.findById(product.getId());

    // Then
    assertEquals(product.toDomain(), res);
  }

  @Test
  void deleteById() {
    // Given
    var product = ProductDAOMother.random();

    // When
    when(repository.findById(product.getId()))
      .thenReturn(java.util.Optional.of(product));
    var res = systemUnderTest.deleteById(product.getId());

    // Then
    assertTrue(res);
  }
}
