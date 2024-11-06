package com.bruno.shoppingjava.invoice.application;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import com.bruno.shoppingjava.invoice.application.request.CreateInvoiceRequest;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateInvoiceUseCase {
  private final InvoiceRepository repository;
  private final ClientRepository clientRepository;
  private final GenerateCodInvoiceUseCase generateCodInvoiceUseCase;

  public InvoiceResponse create(CreateInvoiceRequest request) {
    Invoice invoiceToSave = request.toInvoiceDomain();

    Client client = clientRepository.findById(request.getClientId());

    String invoiceCode = generateCodInvoiceUseCase.generateInvoiceCode()
      .orElseThrow(() -> new RuntimeException("Error generating invoice code"));

    invoiceToSave.setCod_invoice(invoiceCode);
    invoiceToSave.setClient(client);

    LOGGER.info("Creating invoice with code: {}", invoiceToSave);

    Invoice savedInvoice = repository.create(invoiceToSave);
    return InvoiceResponse.toResponse(savedInvoice);
  }
}
