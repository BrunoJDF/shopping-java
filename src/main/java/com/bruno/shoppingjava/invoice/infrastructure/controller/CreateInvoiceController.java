package com.bruno.shoppingjava.invoice.infrastructure.controller;

import com.bruno.shoppingjava.invoice.application.CreateInvoiceUseCase;
import com.bruno.shoppingjava.invoice.application.request.CreateInvoiceRequest;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateInvoiceController extends InvoiceAbstractController {
  private final CreateInvoiceUseCase createInvoiceUseCase;

  @PostMapping
  public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody CreateInvoiceRequest request) {
    InvoiceResponse invoiceResponse = createInvoiceUseCase.create(request);
    return ResponseEntity.ok(invoiceResponse);
  }
}
