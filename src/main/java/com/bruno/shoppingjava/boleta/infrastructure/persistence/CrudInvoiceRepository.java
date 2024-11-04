package com.bruno.shoppingjava.boleta.infrastructure.persistence;

import com.bruno.shoppingjava.boleta.domain.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface CrudInvoiceRepository extends CrudRepository<Invoice, Long> {
}
