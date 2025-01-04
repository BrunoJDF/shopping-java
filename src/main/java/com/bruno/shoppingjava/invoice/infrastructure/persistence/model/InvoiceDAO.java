package com.bruno.shoppingjava.invoice.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(name = "invoice", schema = "shopping_cart")
public class InvoiceDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cod_invoice;
  private BigDecimal sub_total_price;
  private BigDecimal igv;
  private BigDecimal total_price;
  private ZonedDateTime emission_date;
  private ZonedDateTime expiration_date;
  private ZonedDateTime creation_date;
  private ZonedDateTime modification_date;
  private String status;

  // Client relationship
  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private ClientDAO client;

  public static InvoiceDAO fromDomain(Invoice toSave) {
    return InvoiceDAO.builder()
      .id(toSave.getId())
      .cod_invoice(toSave.getCodInvoice())
      .sub_total_price(toSave.getSubTotalPrice())
      .igv(toSave.getIgv())
      .total_price(toSave.getTotalPrice())
      .emission_date(toSave.getEmissionDate())
      .expiration_date(toSave.getExpirationDate())
      .creation_date(toSave.getCreationDate())
      .modification_date(toSave.getModificationDate())
      .status(toSave.getStatus())
      .build();
  }

  public Invoice toDomain() {
    return Invoice.builder()
      .id(this.id)
      .codInvoice(this.cod_invoice)
      .subTotalPrice(this.sub_total_price)
      .igv(this.igv)
      .totalPrice(this.total_price)
      .emissionDate(this.emission_date)
      .expirationDate(this.expiration_date)
      .creationDate(this.creation_date)
      .modificationDate(this.modification_date)
      .status(this.status)
      .build();
  }
}
