package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import com.bruno.shoppingjava.client.infrastructure.cache.ClientCacheManager;
import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
  private final CrudClientRepository crudClientRepository;
  private final ClientCacheManager clientCacheManager;

  @Override
  public Client create(Client client) {
    return save(client);
  }

  @Override
  public Client findById(Long id) {
    return clientCacheManager.get(id, key ->
      crudClientRepository.findById(key)
        .map(ClientDAO::toDomain)
        .orElseThrow(() ->
          new ShoppingNotFoundException(Client.class)
        )
    );
  }

  @Override
  public List<Client> findAll() {
    List<ClientDAO> clients = (List<ClientDAO>) crudClientRepository.findAll();
    return clients.stream()
      .map(ClientDAO::toDomain)
      .toList();
  }

  @Override
  public Client update(Client clientToUpdate) {
    return save(clientToUpdate);
  }

  @Override
  public Boolean delete(Long id) {
    return crudClientRepository.findById(id)
      .map(client -> {
        crudClientRepository.delete(client);
        return true;
      })
      .orElse(false);
  }

  private Client save(Client client) {
    ClientDAO clientDAO = ClientDAO.fromDomain(client);
    ClientDAO savedClient = crudClientRepository.save(clientDAO);
    return savedClient.toDomain();
  }
}
