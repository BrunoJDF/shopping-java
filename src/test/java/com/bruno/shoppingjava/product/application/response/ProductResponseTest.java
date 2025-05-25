package com.bruno.shoppingjava.product.application.response;

import com.bruno.shoppingjava.product.ProductUnitTestCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductResponseTest extends ProductUnitTestCase {

  private ProductResponse systemUnderTest;

  @Test
  void toResponse() {
    long id = 1L;
    String name = "Product 1";
    BigDecimal price = BigDecimal.valueOf(10.0);
    systemUnderTest = ProductResponse.builder()
      .id(id)
      .name(name)
      .price(price)
      .build();
    assertEquals(id, systemUnderTest.getId());
    assertEquals(name, systemUnderTest.getName());
    assertEquals(price, systemUnderTest.getPrice());
  }

  @Test
  void toResponseNull() {
    systemUnderTest = ProductResponse.toResponse(null);
    assertNull(systemUnderTest);
  }
}
