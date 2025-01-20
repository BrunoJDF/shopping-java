package com.bruno.shoppingjava.invoice.application.request;

import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetail;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateDetailInvoiceDTO(UUID idProduct, Integer quantity, BigDecimal price, BigDecimal total) {
  public InvoiceDetail toInvoiceDetailDomain() {
    return InvoiceDetail.builder()
      .idProduct(idProduct)
      .quantity(quantity)
      .price(price)
      .total(total)
      .build();
  }
}
