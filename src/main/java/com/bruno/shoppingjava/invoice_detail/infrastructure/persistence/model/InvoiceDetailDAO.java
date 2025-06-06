package com.bruno.shoppingjava.invoice_detail.infrastructure.persistence.model;

import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
import com.bruno.shoppingjava.invoice_detail.domain.InvoiceDetail;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAO;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(name = InvoiceDetailDAO.SQLDetailInvoice.TABLE_NAME)
public class InvoiceDetailDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLDetailInvoice.ID_INVOICE)
  private Long idInvoice;
  @Column(name = SQLDetailInvoice.ID_PRODUCT)
  private Long idProduct;
  @Column(name = SQLDetailInvoice.QUANTITY)
  private Integer quantity;
  @Column(name = SQLDetailInvoice.PRICE)
  private BigDecimal price;
  @Column(name = SQLDetailInvoice.TOTAL)
  private BigDecimal total;

  @ManyToOne
  @JoinColumn(name = "id_invoice", nullable = false, insertable = false, updatable = false)
  private InvoiceDAO invoice;

  @ManyToOne
  @JoinColumn(name = "id_product", nullable = false, insertable = false, updatable = false)
  private ProductDAO product;

  public static InvoiceDetailDAO fromDetailInvoice(InvoiceDetail invoiceDetail) {
    return InvoiceDetailDAO.builder()
      .id(invoiceDetail.getId())
      .idInvoice(invoiceDetail.getIdInvoice())
      .idProduct(invoiceDetail.getIdProduct())
      .quantity(invoiceDetail.getQuantity())
      .price(invoiceDetail.getPrice())
      .total(invoiceDetail.getTotal())
      .build();
  }

  public InvoiceDetail toDomain() {
    return InvoiceDetail.builder()
      .id(this.id)
      .idInvoice(this.idInvoice)
      .idProduct(this.idProduct)
      .quantity(this.quantity)
      .price(this.price)
      .total(this.total)
      .build();
  }

  static class SQLDetailInvoice {
    static final String TABLE_NAME = "invoice_detail";

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
