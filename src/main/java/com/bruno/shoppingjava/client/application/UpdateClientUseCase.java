package com.bruno.shoppingjava.client.application;

import com.bruno.shoppingjava.client.application.request.UpdateClientRequest;
import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClientUseCase {
  private final ClientRepository clientRepository;

  public ClientResponse update(Long id, UpdateClientRequest request) {
    Client clientFounded = clientRepository.findById(id);
    Client clientToUpdate = request.toClientDomain();

    clientFounded.setName(clientToUpdate.getName());
    clientFounded.setLastName(clientToUpdate.getLastName());
    clientFounded.setFullName(clientToUpdate.getFullName());
    clientFounded.setRuc(clientToUpdate.getRuc());
    clientFounded.setEmail(clientToUpdate.getEmail());
    clientFounded.setPhone(clientToUpdate.getPhone());
    clientFounded.setAddress(clientToUpdate.getAddress());
    clientFounded.setStatus(clientToUpdate.getStatus());

    Client update = clientRepository.update(clientFounded);
    return ClientResponse.toResponse(update);
  }
}
