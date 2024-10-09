package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductUseCase {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
