package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
  private final CrudClientRepository crudClientRepository;

  @Override
  public Client create(Client client) {
    return save(client);
  }

  @Override
  public Client findById(Long id) {
    return crudClientRepository.findById(id)
      .orElseThrow(() ->
        new ShoppingNotFoundException(Client.class)
      );
  }

  @Override
  public List<Client> findAll() {
    return (List<Client>) crudClientRepository.findAll();
  }

  @Override
  public Client update(Client clientToUpdate) {
    return save(clientToUpdate);
  }

  private Client save(Client client) {
    return crudClientRepository.save(client);
  }
}
