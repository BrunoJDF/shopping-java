package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.application.request.CreateProductRequest;
import com.bruno.shoppingjava.product.application.request.CreateProductRequestMother;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateProductUseCaseTest extends ProductUnitTestCase {
  @InjectMocks
  private CreateProductUseCase systemUnderTest;

  @Mock
  private ProductRepository productRepository;

  @Test
  void create() {
    CreateProductRequest request = CreateProductRequestMother.random();


    when(productRepository.save(any()))
      .thenReturn(request.toDomain());

    systemUnderTest.create(request);

    verify(productRepository).save(any());
  }
}
