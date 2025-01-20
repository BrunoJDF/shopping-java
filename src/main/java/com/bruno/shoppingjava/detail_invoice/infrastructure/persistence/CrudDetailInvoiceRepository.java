package com.bruno.shoppingjava.detail_invoice.infrastructure.persistence;

import com.bruno.shoppingjava.detail_invoice.infrastructure.persistence.model.DetailInvoiceDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudDetailInvoiceRepository extends CrudRepository<DetailInvoiceDAO, UUID> {
}
