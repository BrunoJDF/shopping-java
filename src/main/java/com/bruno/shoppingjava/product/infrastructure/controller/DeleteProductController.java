package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.DeleteProductUseCase;
import com.bruno.shoppingjava.product.infrastructure.controller.parent.ProductAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteProductController extends ProductAbstractController {
  private final DeleteProductUseCase deleteProductUseCase;

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
    boolean deleted = deleteProductUseCase.deleteProduct(id);
    return ResponseEntity.accepted().body(deleted);
  }
}
