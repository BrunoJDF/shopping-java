package com.bruno.shoppingjava.invoice.domain;

import com.bruno.shoppingjava.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class Invoice {
  private Long id;
  private String codInvoice;
  private BigDecimal subTotalPrice;
  private BigDecimal igv;
  private BigDecimal totalPrice;
  private ZonedDateTime emissionDate;
  private ZonedDateTime expirationDate;
  private ZonedDateTime creationDate;
  private ZonedDateTime modificationDate;
  private String status;
  private Client client;
}
