package com.bruno.shoppingjava.product.infrastructure.controller;

import com.bruno.shoppingjava.product.application.GetAllProductUseCase;
import com.bruno.shoppingjava.product.application.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GetProductController {

    private final GetAllProductUseCase getAllProductUseCase;

    @GetMapping
    public ResponseEntity<String> home() {
        String message = "Hello, Product!";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(getAllProductUseCase.getAll());
    }
}
