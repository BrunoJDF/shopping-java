package com.bruno.shoppingjava.product.application.response;

import com.bruno.shoppingjava.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal price;

    public static ProductResponse toResponse(Product saved) {
        return ProductResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .price(saved.getPrice())
                .build();
    }
}
