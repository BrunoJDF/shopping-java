package com.bruno.shoppingjava.client.application;

import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetClientUseCase {
  private final ClientRepository repository;

  public ClientResponse getClient(Long id) {
    Client founded = repository.findById(id);
    return ClientResponse.toResponse(founded);
  }

  public List<ClientResponse> getAllClients() {
    return repository.findAll().stream()
      .map(ClientResponse::toResponse)
      .toList();
  }
}
