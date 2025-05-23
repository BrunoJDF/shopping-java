package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.application.request.UpdateProductRequestMother;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAOMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateProductUseCaseTest extends ProductUnitTestCase {
  @InjectMocks
  private UpdateProductUseCase systemUnderTest;
  @Mock
  private ProductRepository productRepository;

  @Test
  void updateProduct() {
    // Given
    var request = UpdateProductRequestMother.random();
    var productDAO = ProductDAOMother.random();
    var productFounded = productDAO.toDomain();
    var id = 1L;

    // When
    when(productRepository.findById(id))
      .thenReturn(productFounded);

    systemUnderTest.updateProduct(request, id);

    // Then
    verify(productRepository, Mockito.times(1)).save(Mockito.any());
  }
}
