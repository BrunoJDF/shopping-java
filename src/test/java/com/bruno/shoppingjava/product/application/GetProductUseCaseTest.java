package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAO;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAOMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class GetProductUseCaseTest extends ProductUnitTestCase {

  @InjectMocks
  private GetProductUseCase systemUnderTest;
  @Mock
  private ProductRepository productRepository;

  @Test
  void getById() {
    // Given
    long id = 1L;
    Product product = ProductDAOMother.random().toDomain();

    // When
    when(productRepository.findById(id))
      .thenReturn(product);

    var result = systemUnderTest.getById(id);

    // Then
    assertNotNull(result, "Product should not be null");
    assertEquals(product.getId(), result.getId(), "Product ID should match");
    assertEquals(product.getName(), result.getName(), "Product name should match");
  }

  @Test
  void getAll() {
    // Given
    var products = ProductDAOMother.randomList().stream()
      .map(ProductDAO::toDomain)
      .toList();

    // When
    when(productRepository.getAll())
      .thenReturn(products);

    var result = systemUnderTest.getAll();

    // Then
    assertNotNull(result, "Product list should not be null");
    assertEquals(products.size(), result.size(), "Product list size should match");

    for (int i = 0; i < products.size(); i++) {
      assertEquals(products.get(i).getId(), result.get(i).getId(), "Product ID at index " + i + " should match");
      assertEquals(products.get(i).getName(), result.get(i).getName(), "Product name at index " + i + " should match");
    }
  }
}
