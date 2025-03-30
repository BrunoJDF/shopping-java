package com.bruno.shoppingjava.invoice.application;

import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetInvoiceUseCase {
  private final InvoiceRepository invoiceRepository;

  public InvoiceResponse getById(Long id) {
    var invoice = invoiceRepository.findById(id);
    return InvoiceResponse.toResponse(invoice);
  }
}
