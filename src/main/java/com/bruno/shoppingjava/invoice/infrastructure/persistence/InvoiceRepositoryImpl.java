package com.bruno.shoppingjava.invoice.infrastructure.persistence;

import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
  private final CrudInvoiceRepository crudInvoiceRepository;
}
