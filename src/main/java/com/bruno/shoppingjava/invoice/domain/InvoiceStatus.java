package com.bruno.shoppingjava.invoice.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InvoiceStatus {
  PENDING(1, "Pendiente"),
  PAID(2, "Pagado"),
  CANCELLED(3, "Cancelado");

  private final int priority;
  private final String description;
}
