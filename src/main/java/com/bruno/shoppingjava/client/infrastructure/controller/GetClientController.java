package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.GetClientUseCase;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetClientController extends ClientAbstractController {
  private final GetClientUseCase getClientUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<ClientResponse> getClient(@PathVariable Long id) {
    var body = getClientUseCase.getClient(id);
    return ResponseEntity.ok(body);
  }

  @GetMapping
  public ResponseEntity<List<ClientResponse>> getAllClients() {
    var body = getClientUseCase.getAllClients();
    return ResponseEntity.ok(body);
  }
}
