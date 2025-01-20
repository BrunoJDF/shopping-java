package com.bruno.shoppingjava.detail_invoice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailInvoice {
  private UUID id;
  private UUID idInvoice;
  private UUID idProduct;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal total;
}
