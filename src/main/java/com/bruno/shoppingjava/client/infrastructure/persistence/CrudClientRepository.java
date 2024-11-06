package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface CrudClientRepository extends CrudRepository<Client, Long> {
}
