package com.bruno.shoppingjava.invoice.application;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import com.bruno.shoppingjava.invoice.application.request.CreateDetailInvoiceDTO;
import com.bruno.shoppingjava.invoice.application.request.CreateInvoiceRequest;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import com.bruno.shoppingjava.invoice_detail.application.CreateInvoiceDetailUseCase;
import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
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
  private final CreateInvoiceDetailUseCase createInvoiceDetailUseCase;

  public InvoiceResponse create(CreateInvoiceRequest request) {
    Invoice invoiceToSave = request.toInvoiceDomain();

    Client client = clientRepository.findById(request.getClientId());

    String invoiceCode = generateCodInvoiceUseCase.generateInvoiceCode()
      .orElseThrow(() -> new ShoppingRuntimeException("Error generating invoice code"));

    invoiceToSave.setCodInvoice(invoiceCode);
    invoiceToSave.setClient(client);

    LOGGER.info("Creating invoice with code: {}", invoiceToSave);

    Invoice savedInvoice = repository.create(invoiceToSave);

    // Create invoice details

    var invoiceDetails = request.getDetails()
      .stream()
      .map(CreateDetailInvoiceDTO::toInvoiceDetailDomain)
      .toList();

    createInvoiceDetailUseCase.createAll(invoiceDetails, savedInvoice);


    return InvoiceResponse.toResponse(savedInvoice);
  }
}
