package com.bruno.shoppingjava.product.application.request;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

public class CreateProductRequestMother {
  public static CreateProductRequest random() {
    var product = new CreateProductRequest();
    product.setName(WordMother.random());
    product.setPrice(BigDecimalMother.random());
    return product;
  }
}
