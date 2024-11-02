package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.CreateProductUseCase;
import com.bruno.shoppingjava.product.application.request.CreateProductRequest;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class CreateProductController {

  private final CreateProductUseCase createProductUseCase;

  @PostMapping("/create")
  public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
    var data = createProductUseCase.create(request);
    return ResponseEntity.ok(data);
  }
}
