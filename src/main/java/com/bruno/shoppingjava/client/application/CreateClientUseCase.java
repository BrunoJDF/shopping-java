package com.bruno.shoppingjava.client.application;

import com.bruno.shoppingjava.client.application.request.CreateClientRequest;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClientUseCase {
  private final ClientRepository clientRepository;

  public ClientResponse createClient(CreateClientRequest client) {
    var toSave = clientRepository.create(client.toClientDomain());
    return ClientResponse.toResponse(toSave);
  }
}
