package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductUseCase {
  private final ProductRepository productRepository;

  public List<ProductResponse> getAll() {
    return productRepository.getAll().stream()
      .map(ProductResponse::toResponse)
      .toList();
  }
}
