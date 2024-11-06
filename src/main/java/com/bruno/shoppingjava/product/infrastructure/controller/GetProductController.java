package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.GetAllProductUseCase;
import com.bruno.shoppingjava.product.application.GetProductUseCase;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetProductController extends ProductAbstractController {

  private final GetAllProductUseCase getAllProductUseCase;
  private final GetProductUseCase getProductUseCase;

  @GetMapping
  public ResponseEntity<String> home() {
    String message = "Hello, Product!";
    return ResponseEntity.ok(message);
  }

  @GetMapping("/get-all")
  public ResponseEntity<List<ProductResponse>> findAll() {
    return ResponseEntity.ok(getAllProductUseCase.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
    return ResponseEntity.ok(getProductUseCase.getById(id));
  }
}
