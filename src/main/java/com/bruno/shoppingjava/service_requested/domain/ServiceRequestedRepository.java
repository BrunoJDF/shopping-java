package com.bruno.shoppingjava.service_requested.domain;

import java.util.List;

public interface ServiceRequestedRepository {
  void saveAllServiceRequested(List<ServiceRequested> serviceRequestedList);
}
