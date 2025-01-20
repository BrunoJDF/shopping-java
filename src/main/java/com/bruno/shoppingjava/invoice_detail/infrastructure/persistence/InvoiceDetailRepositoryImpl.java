package com.bruno.shoppingjava.invoice_detail.infrastructure.persistence;

import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetail;
import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetailRepository;
import com.bruno.shoppingjava.invoice_detail.infrastructure.persistence.model.InvoiceDetailDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class InvoiceDetailRepositoryImpl implements InvoiceDetailRepository {

  private final CrudInvoiceDetailRepository crudInvoiceDetailRepository;

  @Override
  public InvoiceDetail save(InvoiceDetail invoiceDetail) {
    InvoiceDetailDAO toSave = InvoiceDetailDAO.fromDetailInvoice(invoiceDetail);
    InvoiceDetailDAO res = crudInvoiceDetailRepository.save(toSave);
    return res.toDomain();
  }

  @Override
  public Optional<InvoiceDetail> findById(String id) {
    return crudInvoiceDetailRepository.findById(UUID.fromString(id))
      .map(InvoiceDetailDAO::toDomain);
  }
}
