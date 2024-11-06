package com.bruno.shoppingjava.invoice.application.response;

import com.bruno.shoppingjava.client.application.response.ClientResponse;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
  private Long id;
  private String codInvoice;
  private BigDecimal subTotalPrice;
  private BigDecimal igv;
  private BigDecimal totalPrice;
  private ZonedDateTime emissionDate;
  private ZonedDateTime expirationDate;
  private ClientResponse client;
  private String status;

  public static InvoiceResponse toResponse(Invoice savedInvoice) {
    ClientResponse clientResponse = ClientResponse.toResponse(savedInvoice.getClient());
    return InvoiceResponse.builder()
      .id(savedInvoice.getId())
      .codInvoice(savedInvoice.getCod_invoice())
      .subTotalPrice(savedInvoice.getSub_total_price())
      .igv(savedInvoice.getIgv())
      .totalPrice(savedInvoice.getTotal_price())
      .emissionDate(savedInvoice.getEmission_date())
      .expirationDate(savedInvoice.getExpiration_date())
      .status(savedInvoice.getStatus())
      .client(clientResponse)
      .build();
  }
}
