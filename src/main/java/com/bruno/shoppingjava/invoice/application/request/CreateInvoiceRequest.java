package com.bruno.shoppingjava.invoice.application.request;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
  private String codInvoice;
  private BigDecimal subTotalPrice;

  public Invoice toInvoiceDomain() {
    return Optional.of(this)
      .map(inv -> {
        BigDecimal igv =
          subTotalPrice.multiply(new BigDecimal("0.18"));
        BigDecimal totalPrice =
          subTotalPrice.add(igv);
        return Invoice.builder()
            .cod_invoice(inv.getCodInvoice())
            .sub_total_price(inv.getSubTotalPrice())
            .igv(igv)
            .total_price(totalPrice)
            .creation_date(ZonedDateTime.now())
            .modification_date(ZonedDateTime.now())
            .emission_date(ZonedDateTime.now())
            .expiration_date(ZonedDateTime.now().plusDays(2))
            .status(InvoiceStatus.PENDING.getDescription())
            .build();
        }
      ).orElse(null);
  }
}
