package com.bruno.shoppingjava.client.domain;

import java.util.List;

public interface ClientRepository {
  Client create(Client client);

  Client findById(Long id);

  List<Client> findAll();
}
