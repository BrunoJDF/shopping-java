package com.bruno.shoppingjava.service_requested.infrastructure.persistence;

import com.bruno.shoppingjava.service_requested.domain.ServiceRequested;
import com.bruno.shoppingjava.service_requested.domain.ServiceRequestedRepository;
import com.bruno.shoppingjava.service_requested.infrastructure.persistence.model.ServiceRequestedDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ServiceRequestedRepositoryImpl implements ServiceRequestedRepository {

  private final CrudServiceRequestedRepository crudServiceRequestedRepository;

  @Override
  public void saveAllServiceRequested(List<ServiceRequested> serviceRequestedList) {
    List<ServiceRequestedDAO> entities = serviceRequestedList.stream()
      .map(ServiceRequestedDAO::fromDomain)
      .toList();

    crudServiceRequestedRepository.saveAll(entities);
  }
}
