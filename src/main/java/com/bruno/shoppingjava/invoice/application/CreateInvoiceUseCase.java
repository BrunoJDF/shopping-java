package com.bruno.shoppingjava.invoice.application;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import com.bruno.shoppingjava.invoice.application.request.CreateDetailInvoiceDTO;
import com.bruno.shoppingjava.invoice.application.request.CreateInvoiceRequest;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceRepository;
import com.bruno.shoppingjava.invoice_detail.application.CreateInvoiceDetailUseCase;
import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetail;
import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateInvoiceUseCase {
  private final InvoiceRepository repository;
  private final ClientRepository clientRepository;
  private final ProductRepository productRepository;
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

    List<InvoiceDetail> invoiceDetails = request.getDetails()
      .stream()
      .map(createDetailInvoiceDTO -> buildInvoiceDetail(createDetailInvoiceDTO, savedInvoice))
      .toList();

    createInvoiceDetailUseCase.createAll(invoiceDetails);


    return InvoiceResponse.toResponse(savedInvoice);
  }

  private InvoiceDetail buildInvoiceDetail(CreateDetailInvoiceDTO createDetailInvoiceDTO, Invoice savedInvoice) {
    Product product = productRepository.findById(createDetailInvoiceDTO.idProduct());
    BigDecimal total = product.getPrice().multiply(BigDecimal.valueOf(createDetailInvoiceDTO.quantity()));
    return InvoiceDetail.builder()
      .idProduct(product.getId())
      .quantity(createDetailInvoiceDTO.quantity())
      .price(product.getPrice())
      .idInvoice(savedInvoice.getId())
      .total(total)
      .build();
  }
}
