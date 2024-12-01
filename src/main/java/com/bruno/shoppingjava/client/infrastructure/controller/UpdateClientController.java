package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.UpdateClientUseCase;
import com.bruno.shoppingjava.client.application.request.UpdateClientRequest;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.infrastructure.controller.parent.ClientAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateClientController extends ClientAbstractController {
  private final UpdateClientUseCase updateClientUseCase;

  @PatchMapping("/{id}")
  public ResponseEntity<ClientResponse> updateClient(@PathVariable Long id, @RequestBody UpdateClientRequest request) {
    ClientResponse update = updateClientUseCase.update(id, request);
    return ResponseEntity.ok(update);
  }
}
