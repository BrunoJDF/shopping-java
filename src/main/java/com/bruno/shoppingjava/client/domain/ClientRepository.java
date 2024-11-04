package com.bruno.shoppingjava.client.domain;

public interface ClientRepository {
  Client create(Client client);

  Client findById(Long id);
}
