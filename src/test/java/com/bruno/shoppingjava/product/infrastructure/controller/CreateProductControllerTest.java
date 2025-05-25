package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.application.CreateProductUseCase;
import com.bruno.shoppingjava.product.application.request.CreateProductRequestMother;
import com.bruno.shoppingjava.product.application.response.ProductResponseMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CreateProductControllerTest extends ProductUnitTestCase {

  @InjectMocks
  private CreateProductController systemUnderTest;
  @Mock
  private CreateProductUseCase createProductUseCase;

  @Test
  void createProduct() {
    // Given
    var request = CreateProductRequestMother.random();
    var response = ProductResponseMother.createFromRequest(request);

    when(createProductUseCase.create(request))
      .thenReturn(response);

    // When
    var result = systemUnderTest.createProduct(request);

    // Then
    assertEquals(response, result.getBody());
    assertEquals(200, result.getStatusCode().value(), "Status code should be 200");
  }
}
