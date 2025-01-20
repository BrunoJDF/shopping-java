package com.bruno.shoppingjava.invoice_detail.domain;

public interface InvoiceDetailRepository {
  InvoiceDetail save(InvoiceDetail invoiceDetail);

  InvoiceDetail findById(String id);
}
