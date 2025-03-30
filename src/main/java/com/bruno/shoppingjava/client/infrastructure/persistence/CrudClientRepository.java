package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import org.springframework.data.repository.CrudRepository;

public interface CrudClientRepository extends CrudRepository<ClientDAO, Long> {
}
