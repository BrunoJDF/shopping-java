package com.bruno.shoppingjava.invoice.infrastructure.persistence;

import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
import org.springframework.data.repository.CrudRepository;

public interface CrudInvoiceRepository extends CrudRepository<InvoiceDAO, Long> {
}
