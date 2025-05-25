package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase {
  private final ProductRepository productRepository;

  public Boolean deleteProduct(Long id) {
    return productRepository.deleteById(id);
  }
}
