package com.bruno.shoppingjava.invoice_detail.application;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetail;
import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateInvoiceDetailUseCase {
  private final InvoiceDetailRepository repository;

  public void createAll(List<InvoiceDetail> invoiceDetails, Invoice savedInvoice) {
    invoiceDetails.parallelStream().forEach(invoiceDetail -> {
      invoiceDetail.setIdInvoice(savedInvoice.getId());
      repository.save(invoiceDetail);
    });
  }
}
