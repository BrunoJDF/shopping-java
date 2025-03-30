package com.bruno.shoppingjava.invoice.infrastructure.persistence;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
  private final CrudInvoiceRepository crudInvoiceRepository;

  @Override
  public Invoice create(Invoice toSave) {
    InvoiceDAO invoice = InvoiceDAO.fromDomain(toSave);
    InvoiceDAO saved = crudInvoiceRepository.save(invoice);
    return saved.toDomain();
  }

  @Override
  public Invoice findById(Long id) {
    return crudInvoiceRepository.findById(id)
      .map(InvoiceDAO::toDomain)
      .orElseThrow(() ->
        new ShoppingNotFoundException(Invoice.class)
      );
  }
}
