package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import com.bruno.shoppingjava.product.application.GetProductUseCase;
import com.bruno.shoppingjava.product.application.response.ProductResponseMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class GetProductControllerTest extends ProductUnitTestCase {

  @InjectMocks
  private GetProductController systemUnderTest;
  @Mock
  private GetProductUseCase useCase;

  @Test
  void home() {
    // Given
    String expectedMessage = "Hello, Product!";

    // When
    var response = systemUnderTest.home();

    // Then
    assertNotNull(response, "Response should not be null");
    assertEquals(expectedMessage, response.getBody(), "Response message should match");
    assertEquals(200, response.getStatusCode().value(), "Status code should be 200");
  }

  @Test
  void findAll() {
    // Given
    var listResponse = ProductResponseMother.randomList();

    // When
    when(useCase.getAll())
      .thenReturn(listResponse);

    var response = systemUnderTest.findAll();

    // Then
    assertNotNull(response, "Response should not be null");
    assertEquals(200, response.getStatusCode().value(), "Status code should be 200");
    assertNotNull(response.getBody(), "Response body should not be null");
    assertEquals(listResponse.size(), response.getBody().size(), "Response body size should match");
  }

  @Test
  void findById() {
    // Given
    long id = 1L;
    var response = ProductResponseMother.random();

    // When
    when(useCase.getById(id))
      .thenReturn(response);

    var result = systemUnderTest.findById(id);

    // Then
    assertNotNull(result, "Response should not be null");
    assertEquals(200, result.getStatusCode().value(), "Status code should be 200");
    assertNotNull(result.getBody(), "Response body should not be null");
    assertEquals(response, result.getBody(), "Response body should match expected product");
  }
}
