package com.bruno.shoppingjava.detail_invoice.domain;

import java.util.Optional;

public interface DetailInvoiceRepository {
  DetailInvoice save(DetailInvoice detailInvoice);

  Optional<DetailInvoice> findById(String id);
}
