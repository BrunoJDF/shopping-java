package com.bruno.shoppingjava.invoice.domain;

public interface InvoiceRepository {
    Invoice create(Invoice toSave);
}
