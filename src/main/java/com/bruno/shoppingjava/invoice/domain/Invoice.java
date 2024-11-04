package com.bruno.shoppingjava.invoice.domain;

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
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(name = "invoice", schema = "shopping_cart")
public class Invoice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long cod_invoice;
  private Long cod_cliente;
  private BigDecimal sub_total_price;
  private BigDecimal igv;
  private BigDecimal total_price;
  private ZonedDateTime emission_date;
  private ZonedDateTime expiration_date;
  private ZonedDateTime creation_date;
  private ZonedDateTime modification_date;
  private String status;
}
