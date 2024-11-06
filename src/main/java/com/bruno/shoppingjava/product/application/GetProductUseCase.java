package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductUseCase {
  private final ProductRepository repository;

  public ProductResponse getById(Long id) {
    var founded = repository.findById(id);
    return ProductResponse.toResponse(founded);
  }
}
