package com.bruno.shoppingjava.invoice.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.invoice.domain.Invoice;
import com.bruno.shoppingjava.shared.infrastructure.persistence.SQLConstants;
import jakarta.persistence.Column;
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
@Table(name = InvoiceDAO.SQLInvoice.TABLE_NAME, schema = SQLConstants.SCHEMA)
public class InvoiceDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLInvoice.COD_INVOICE)
  private String codInvoice;
  @Column(name = SQLInvoice.SUB_TOTAL_PRICE)
  private BigDecimal subTotalPrice;
  @Column(name = SQLInvoice.IGV)
  private BigDecimal igv;
  @Column(name = SQLInvoice.TOTAL_PRICE)
  private BigDecimal totalPrice;
  @Column(name = SQLInvoice.EMISSION_DATE)
  private ZonedDateTime emissionDate;
  @Column(name = SQLInvoice.EXPIRATION_DATE)
  private ZonedDateTime expirationDate;
  @Column(name = SQLInvoice.CREATION_DATE)
  private ZonedDateTime creationDate;
  @Column(name = SQLInvoice.MODIFICATION_DATE)
  private ZonedDateTime modificationDate;
  @Column(name = SQLInvoice.STATUS)
  private String status;

  // Client relationship
  @ManyToOne
  @JoinColumn(name = "id_client")
  private ClientDAO client;

  public static InvoiceDAO fromDomain(Invoice toSave) {
    return InvoiceDAO.builder()
      .id(toSave.getId())
      .codInvoice(toSave.getCodInvoice())
      .subTotalPrice(toSave.getSubTotalPrice())
      .igv(toSave.getIgv())
      .totalPrice(toSave.getTotalPrice())
      .emissionDate(toSave.getEmissionDate())
      .expirationDate(toSave.getExpirationDate())
      .creationDate(toSave.getCreationDate())
      .modificationDate(toSave.getModificationDate())
      .status(toSave.getStatus())
      .build();
  }

  public Invoice toDomain() {
    return Invoice.builder()
      .id(this.id)
      .codInvoice(this.codInvoice)
      .subTotalPrice(this.subTotalPrice)
      .igv(this.igv)
      .totalPrice(this.totalPrice)
      .emissionDate(this.emissionDate)
      .expirationDate(this.expirationDate)
      .creationDate(this.creationDate)
      .modificationDate(this.modificationDate)
      .status(this.status)
      .build();
  }

  static class SQLInvoice {
    static final String TABLE_NAME = "invoice";

    private SQLInvoice() {
      throw new IllegalStateException("Utility class");
    }

    static final String COD_INVOICE = "cod_invoice";
    static final String SUB_TOTAL_PRICE = "sub_total_price";
    static final String IGV = "igv";
    static final String TOTAL_PRICE = "total_price";
    static final String EMISSION_DATE = "emission_date";
    static final String EXPIRATION_DATE = "expiration_date";
    static final String CREATION_DATE = "creation_date";
    static final String MODIFICATION_DATE = "modification_date";
    static final String STATUS = "status";
  }
}
