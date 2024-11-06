package com.bruno.shoppingjava.invoice.infrastructure.persistence;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
  private final CrudInvoiceRepository crudInvoiceRepository;

  @Override
  public Invoice create(Invoice toSave) {
    return crudInvoiceRepository.save(toSave);
  }

  @Override
  public Invoice findById(Long id) {
    return crudInvoiceRepository.findById(id)
      .orElseThrow(() ->
        new ShoppingNotFoundException(Invoice.class)
      );
  }
}
