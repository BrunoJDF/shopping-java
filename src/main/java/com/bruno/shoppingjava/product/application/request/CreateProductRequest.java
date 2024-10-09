package com.bruno.shoppingjava.product.application.request;

import com.bruno.shoppingjava.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private String name;
    private BigDecimal price;

    public Product toProductDomain() {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }
}
