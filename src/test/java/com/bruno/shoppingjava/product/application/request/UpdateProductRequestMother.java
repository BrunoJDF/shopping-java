package com.bruno.shoppingjava.product.application.request;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

public class UpdateProductRequestMother {

  public static UpdateProductRequest random() {
    return UpdateProductRequest.builder()
      .name(WordMother.random())
      .price(BigDecimalMother.random())
      .build();
  }
}
