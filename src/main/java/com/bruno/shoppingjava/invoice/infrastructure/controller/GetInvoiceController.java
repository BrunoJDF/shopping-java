package com.bruno.shoppingjava.invoice.infrastructure.controller;

import com.bruno.shoppingjava.invoice.application.GetInvoiceUseCase;
import com.bruno.shoppingjava.invoice.application.response.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetInvoiceController extends InvoiceAbstractController {
  private final GetInvoiceUseCase getInvoiceUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable Long id) {
    InvoiceResponse invoiceResponse = getInvoiceUseCase.getById(id);
    return ResponseEntity.ok(invoiceResponse);
  }
}
