package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
  private final CrudClientRepository crudClientRepository;

  @Override
  public Client create(Client client) {
    return crudClientRepository.save(client);
  }
}
