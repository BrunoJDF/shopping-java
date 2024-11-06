package com.bruno.shoppingjava.invoice.infrastructure.persistence;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface CrudInvoiceRepository extends CrudRepository<Invoice, Long> {
}
