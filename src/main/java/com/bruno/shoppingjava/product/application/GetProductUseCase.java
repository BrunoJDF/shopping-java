package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductUseCase {
  private final ProductRepository repository;

  public ProductResponse getById(Long id) {
    var founded = repository.findById(id);
    return ProductResponse.toResponse(founded);
  }

  public List<ProductResponse> getAll() {
    return repository.getAll().stream()
      .map(ProductResponse::toResponse)
      .toList();
  }
}
