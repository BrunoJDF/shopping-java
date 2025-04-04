package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.CreateProductUseCase;
import com.bruno.shoppingjava.product.application.request.CreateProductRequest;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.infrastructure.controller.parent.ProductAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateProductController extends ProductAbstractController {

  private final CreateProductUseCase createProductUseCase;

  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
    ProductResponse data = createProductUseCase.create(request);
    return ResponseEntity.ok(data);
  }
}
