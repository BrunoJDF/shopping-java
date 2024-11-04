package com.bruno.shoppingjava.product.application.response;

import com.bruno.shoppingjava.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
  private Long id;
  private String name;
  private BigDecimal price;

  public static ProductResponse toResponse(Product saved) {
    return Optional.ofNullable(saved)
      .map(product -> ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .price(product.getPrice())
        .build())
      .orElse(null);
  }
}
