package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.CreateClientUseCase;
import com.bruno.shoppingjava.client.application.request.CreateClientRequest;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.infrastructure.controller.parent.ClientAbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateClientController extends ClientAbstractController {
  private final CreateClientUseCase createClientUseCase;

  @PostMapping
  public ResponseEntity<ClientResponse> createClient(@RequestBody CreateClientRequest client) {
    ClientResponse responseClient = createClientUseCase.createClient(client);
    return ResponseEntity.ok(responseClient);
  }
}
