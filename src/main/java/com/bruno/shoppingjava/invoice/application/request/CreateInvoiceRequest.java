package com.bruno.shoppingjava.invoice.application.request;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.invoice.domain.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
  private static final String IGV = "0.18";
  private BigDecimal subTotalPrice;
  private Long clientId;
  private List<CreateDetailInvoiceDTO> details;

  public Invoice toInvoiceDomain() {
    return Optional.of(this)
      .map(inv -> {
          BigDecimal igv =
            subTotalPrice.multiply(new BigDecimal(IGV));
          BigDecimal totalPrice =
            subTotalPrice.add(igv);
          return Invoice.builder()
            .subTotalPrice(inv.getSubTotalPrice())
            .igv(igv)
            .totalPrice(totalPrice)
            .creationDate(ZonedDateTime.now())
            .modificationDate(ZonedDateTime.now())
            .emissionDate(ZonedDateTime.now())
            .expirationDate(ZonedDateTime.now().plusDays(2))
            .status(InvoiceStatus.PENDING.getDescription())
            .build();
        }
      ).orElse(null);
  }
}
