package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.DeleteClientUseCase;
import com.bruno.shoppingjava.client.infrastructure.controller.parent.ClientAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteClientController extends ClientAbstractController {
  private final DeleteClientUseCase deleteClientUseCase;

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteClient(@PathVariable Long id) {
    return ResponseEntity.accepted().body(deleteClientUseCase.delete(id));
  }
}
