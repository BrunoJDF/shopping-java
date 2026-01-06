package com.bruno.shoppingjava.service_requested.application;

import com.bruno.shoppingjava.service_requested.application.dto.ServiceRequestedFileDTO;
import com.bruno.shoppingjava.service_requested.domain.ServiceRequested;
import com.bruno.shoppingjava.service_requested.domain.ServiceRequestedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateServiceRequestedUseCase {
  private final ServiceRequestedRepository serviceRequestedRepository;

  public void createServiceRequestedFromImport(List<List<String>> records) {
    // First line is header, so we start from index 1
    List<ServiceRequestedFileDTO> fileDTOS = new ArrayList<>();
    for (int i = 1; i < records.size(); i++) {
      List<String> row = records.get(i);
      ServiceRequestedFileDTO serviceRequested = ServiceRequestedFileDTO.fromRecord(row);
      fileDTOS.add(serviceRequested);
    }

    List<ServiceRequested> serviceRequestedList = fileDTOS.stream()
      .map(ServiceRequestedFileDTO::toDomain)
      .toList();

    serviceRequestedRepository.saveAllServiceRequested(serviceRequestedList);
  }
}
