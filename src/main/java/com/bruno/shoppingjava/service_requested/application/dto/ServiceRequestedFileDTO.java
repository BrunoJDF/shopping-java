package com.bruno.shoppingjava.service_requested.application.dto;

import com.bruno.shoppingjava.service_requested.domain.ServiceRequested;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestedFileDTO {
  private String clientName;
  private String sellerName;
  private BigDecimal commission;
  private String serviceName;
  private String serviceDescription;

  public static ServiceRequestedFileDTO fromRecord(List<String> recordFile) {
    return ServiceRequestedFileDTO.builder()
      .clientName(recordFile.get(0))
      .sellerName(recordFile.get(1))
      .commission(new BigDecimal(recordFile.get(2)))
      .serviceName(recordFile.get(3))
      .serviceDescription(recordFile.get(4))
      .build();
  }

  public ServiceRequested toDomain() {
    return ServiceRequested.builder()
      .serviceName(this.serviceName)
      .description(this.serviceDescription)
      .seller(this.sellerName)
      .commission(this.commission)
      .build();
  }
}
