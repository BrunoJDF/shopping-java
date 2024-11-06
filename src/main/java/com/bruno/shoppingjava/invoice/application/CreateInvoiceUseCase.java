package com.bruno.shoppingjava.invoice.application;

import com.bruno.shoppingjava.invoice.application.request.CreateInvoiceRequest;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateInvoiceUseCase {
  private final InvoiceRepository repository;

  public InvoiceResponse create(CreateInvoiceRequest request) {
    var invoiceToSave = request.toInvoiceDomain();
    var savedInvoice = repository.create(invoiceToSave);
    return InvoiceResponse.toResponse(savedInvoice);
  }
}
