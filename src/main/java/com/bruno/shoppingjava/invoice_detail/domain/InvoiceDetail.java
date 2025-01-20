package com.bruno.shoppingjava.invoice_detail.domain;

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
public class InvoiceDetail {
  private UUID id;
  private Long idInvoice;
  private Long idProduct;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal total;
}
