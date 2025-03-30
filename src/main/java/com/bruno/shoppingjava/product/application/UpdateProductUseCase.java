package com.bruno.shoppingjava.product.application;

import com.bruno.shoppingjava.product.application.request.UpdateProductRequest;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {
  private final ProductRepository productRepository;

  public ProductResponse updateProduct(UpdateProductRequest request, Long id) {
    Product product = productRepository.findById(id);
    product.setName(request.getName());
    product.setPrice(request.getPrice());

    Product saved = productRepository.save(product);
    return ProductResponse.toResponse(saved);
  }
}
