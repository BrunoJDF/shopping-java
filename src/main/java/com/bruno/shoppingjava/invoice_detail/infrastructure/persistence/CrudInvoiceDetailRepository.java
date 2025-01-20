package com.bruno.shoppingjava.invoice_detail.infrastructure.persistence;

import com.bruno.shoppingjava.invoice_detail.infrastructure.persistence.model.InvoiceDetailDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CrudInvoiceDetailRepository extends CrudRepository<InvoiceDetailDAO, UUID> {
}
