package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DeleteProductUseCaseTest extends ProductUnitTestCase {

  @InjectMocks
  private DeleteProductUseCase systemUnderTest;
  @Mock
  private ProductRepository productRepository;

  @Test
  void deleteProduct() {
    // Given
    long id = 1L;

    // When
    when(productRepository.deleteById(id))
      .thenReturn(true);

    Boolean result = systemUnderTest.deleteProduct(id);

    // Then
    assertEquals(Boolean.TRUE, result);
  }
}
