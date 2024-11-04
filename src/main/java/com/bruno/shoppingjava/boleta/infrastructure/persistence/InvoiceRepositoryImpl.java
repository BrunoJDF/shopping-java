package com.bruno.shoppingjava.boleta.infrastructure.persistence;

import com.bruno.shoppingjava.boleta.domain.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
  private final CrudInvoiceRepository crudInvoiceRepository;
}
