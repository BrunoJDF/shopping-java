package com.bruno.shoppingjava.service_requested.infrastructure.persistence;

import com.bruno.shoppingjava.service_requested.infrastructure.persistence.model.ServiceRequestedDAO;
import org.springframework.data.repository.CrudRepository;

public interface CrudServiceRequestedRepository extends CrudRepository<ServiceRequestedDAO, Long> {
}
