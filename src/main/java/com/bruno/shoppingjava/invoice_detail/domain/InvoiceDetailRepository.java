package com.bruno.shoppingjava.invoice_detail.domain;

import java.util.Optional;

public interface InvoiceDetailRepository {
  InvoiceDetail save(InvoiceDetail invoiceDetail);

  Optional<InvoiceDetail> findById(String id);
}
