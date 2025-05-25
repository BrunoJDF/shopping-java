package com.bruno.shoppingjava.product.domain;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

public class ProductMother {
  public static Product random() {
    return Product.builder()
      .id(BigDecimalMother.random().longValue())
      .name(WordMother.random())
      .price(BigDecimalMother.random())
      .build();
  }
}
