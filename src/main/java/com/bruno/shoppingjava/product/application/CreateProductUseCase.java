package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.application.request.CreateProductRequest;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final ProductRepository productRepository;

    public ProductResponse create(CreateProductRequest request) {
        var saved = productRepository.save(request.toProductDomain());
        return ProductResponse.toResponse(saved);
    }
}
