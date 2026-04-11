package com.bruno.shoppingjava.service_requested.domain;

import com.bruno.shoppingjava.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequested {
  private String id;
  private String description;
  private String serviceName;
  private Client client;
  private String seller;
  private BigDecimal commission;
  private BigDecimal subtotal;
  private BigDecimal total;
  private ServiceStatus status;
}
