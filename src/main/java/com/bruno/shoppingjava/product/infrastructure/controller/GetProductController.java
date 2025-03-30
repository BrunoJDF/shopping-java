package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.GetProductUseCase;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.infrastructure.controller.parent.ProductAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetProductController extends ProductAbstractController {

  private final GetProductUseCase getProductUseCase;

  @GetMapping("/home")
  public ResponseEntity<String> home() {
    String message = "Hello, Product!";
    return ResponseEntity.ok(message);
  }

  @GetMapping
  public ResponseEntity<List<ProductResponse>> findAll() {
    List<ProductResponse> productList = getProductUseCase.getAll();
    return ResponseEntity.ok(productList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
    ProductResponse productResponse = getProductUseCase.getById(id);
    return ResponseEntity.ok(productResponse);
  }
}
