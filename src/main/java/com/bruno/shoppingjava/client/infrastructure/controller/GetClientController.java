package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.GetClientUseCase;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.infrastructure.controller.parent.ClientAbstractController;
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
    ClientResponse body = getClientUseCase.getClient(id);
    return ResponseEntity.ok(body);
  }

  @GetMapping
  public ResponseEntity<List<ClientResponse>> getAllClients() {
    List<ClientResponse> body = getClientUseCase.getAllClients();
    return ResponseEntity.ok(body);
  }
}
