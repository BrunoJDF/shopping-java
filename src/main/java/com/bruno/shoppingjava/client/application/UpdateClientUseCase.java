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
    var clientFounded = clientRepository.findById(id);
    var clientToUpdate = request.toClientDomain();

    clientToUpdate.setId(clientFounded.getId());
    clientToUpdate.setName(clientFounded.getName());
    clientToUpdate.setLast_name(clientFounded.getLast_name());
    clientToUpdate.setFull_name(clientFounded.getFull_name());
    clientToUpdate.setRuc(clientFounded.getRuc());
    clientToUpdate.setEmail(clientFounded.getEmail());
    clientToUpdate.setPhone(clientFounded.getPhone());
    clientToUpdate.setAddress(clientFounded.getAddress());
    clientToUpdate.setStatus(clientFounded.getStatus());

    Client update = clientRepository.update(clientToUpdate);
    return ClientResponse.toResponse(update);
  }
}
