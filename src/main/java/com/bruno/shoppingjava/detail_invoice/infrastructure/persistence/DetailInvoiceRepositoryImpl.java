package com.bruno.shoppingjava.detail_invoice.infrastructure.persistence;

import com.bruno.shoppingjava.detail_invoice.domain.DetailInvoice;
import com.bruno.shoppingjava.detail_invoice.domain.DetailInvoiceRepository;
import com.bruno.shoppingjava.detail_invoice.infrastructure.persistence.model.DetailInvoiceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DetailInvoiceRepositoryImpl implements DetailInvoiceRepository {

  private final CrudDetailInvoiceRepository crudDetailInvoiceRepository;

  @Override
  public DetailInvoice save(DetailInvoice detailInvoice) {
    DetailInvoiceDAO toSave = DetailInvoiceDAO.fromDetailInvoice(detailInvoice);
    DetailInvoiceDAO res = crudDetailInvoiceRepository.save(toSave);
    return res.toDomain();
  }

  @Override
  public Optional<DetailInvoice> findById(String id) {
    return crudDetailInvoiceRepository.findById(UUID.fromString(id))
      .map(DetailInvoiceDAO::toDomain);
  }
}
