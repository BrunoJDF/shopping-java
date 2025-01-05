package com.bruno.shoppingjava.product.infrastructure.persistence.model;

import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.shared.infrastructure.persistence.SQLConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = ProductDAO.SQLProduct.TABLE_NAME, schema = SQLConstants.SCHEMA)
public class ProductDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLProduct.NAME)
  private String name;
  @Column(name = SQLProduct.PRICE)
  private BigDecimal price;

  public static ProductDAO fromDomain(Product product) {
    return ProductDAO.builder()
      .id(product.getId())
      .name(product.getName())
      .price(product.getPrice())
      .build();
  }

  public Product toDomain() {
    return Product.builder()
      .id(this.id)
      .name(this.name)
      .price(this.price)
      .build();
  }

  static class SQLProduct {
    static final String TABLE_NAME = "product";

    private SQLProduct() {
      throw new IllegalStateException("Utility class");
    }

    static final String NAME = "name";
    static final String PRICE = "price";
  }
}
