package com.bruno.shoppingjava.client.infrastructure.controller;

import com.bruno.shoppingjava.client.application.GetClientUseCase;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class GetClientController {
  private final GetClientUseCase getClientUseCase;

  @GetMapping("/{id}")
  public ClientResponse getClient(@PathVariable Long id) {
    return getClientUseCase.getClient(id);
  }
}
