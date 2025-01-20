package com.bruno.shoppingjava.detail_invoice.infrastructure.persistence.model;

import com.bruno.shoppingjava.detail_invoice.domain.DetailInvoice;
import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
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
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(name = DetailInvoiceDAO.SQLDetailInvoice.TABLE_NAME, schema = SQLConstants.SCHEMA)
public class DetailInvoiceDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  @Column(name = SQLDetailInvoice.ID_INVOICE)
  private UUID idInvoice;
  @Column(name = SQLDetailInvoice.ID_PRODUCT)
  private UUID idProduct;
  @Column(name = SQLDetailInvoice.QUANTITY)
  private Integer quantity;
  @Column(name = SQLDetailInvoice.PRICE)
  private BigDecimal price;
  @Column(name = SQLDetailInvoice.TOTAL)
  private BigDecimal total;

  @ManyToOne
  @JoinColumn(name = "id_invoice", nullable = false, insertable = false, updatable = false)
  private InvoiceDAO invoice;

  public static DetailInvoiceDAO fromDetailInvoice(DetailInvoice detailInvoice) {
    return DetailInvoiceDAO.builder()
      .id(detailInvoice.getId())
      .idInvoice(detailInvoice.getIdInvoice())
      .idProduct(detailInvoice.getIdProduct())
      .quantity(detailInvoice.getQuantity())
      .price(detailInvoice.getPrice())
      .total(detailInvoice.getTotal())
      .build();
  }

  public DetailInvoice toDomain() {
    return DetailInvoice.builder()
      .id(this.id)
      .idInvoice(this.idInvoice)
      .idProduct(this.idProduct)
      .quantity(this.quantity)
      .price(this.price)
      .total(this.total)
      .build();
  }

  static class SQLDetailInvoice {
    static final String TABLE_NAME = "detail_invoice";

    private SQLDetailInvoice() {
      throw new IllegalStateException("Utility class");
    }

    static final String ID_INVOICE = "id_invoice";
    static final String ID_PRODUCT = "id_product";
    static final String QUANTITY = "quantity";
    static final String PRICE = "price";
    static final String TOTAL = "total";
  }
}
