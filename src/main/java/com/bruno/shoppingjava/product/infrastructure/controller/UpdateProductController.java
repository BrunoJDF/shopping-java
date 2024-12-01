package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.UpdateProductUseCase;
import com.bruno.shoppingjava.product.application.request.UpdateProductRequest;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import com.bruno.shoppingjava.product.infrastructure.controller.parent.ProductAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateProductController extends ProductAbstractController {
  private final UpdateProductUseCase updateProductUseCase;

  @PatchMapping("/update/{id}")
  public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request, @PathVariable Long id) {
    var data = updateProductUseCase.updateProduct(request, id);
    return ResponseEntity.ok(data);
  }
}
