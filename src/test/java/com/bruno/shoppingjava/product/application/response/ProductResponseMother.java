package com.bruno.shoppingjava.product.application.response;

import com.bruno.shoppingjava.product.application.request.CreateProductRequest;
import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

import java.util.List;
import java.util.stream.IntStream;

public class ProductResponseMother {
  public static ProductResponse createFromRequest(CreateProductRequest request) {
    return ProductResponse.builder()
        .id(BigDecimalMother.random().longValue())
        .name(request.getName())
        .price(request.getPrice())
        .build();
  }

  public static ProductResponse random() {
    return ProductResponse.builder()
        .id(BigDecimalMother.random().longValue())
        .name("Product " + WordMother.random())
        .price(BigDecimalMother.random())
        .build();
  }

  public static List<ProductResponse> randomList() {
    return IntStream.range(0, 10)
        .mapToObj(i -> random())
        .toList();
  }
}
