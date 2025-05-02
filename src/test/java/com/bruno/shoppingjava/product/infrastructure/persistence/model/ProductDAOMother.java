package com.bruno.shoppingjava.product.infrastructure.persistence.model;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

import java.util.List;
import java.util.stream.IntStream;

public class ProductDAOMother {

  public static ProductDAO random() {
    return ProductDAO.builder()
      .id(BigDecimalMother.random().longValue())
      .name(WordMother.random())
      .price(BigDecimalMother.random())
      .build();
  }

  public static List<ProductDAO> randomList() {
    return IntStream.range(0, 10)
      .mapToObj(value -> random())
      .toList();
  }
}
