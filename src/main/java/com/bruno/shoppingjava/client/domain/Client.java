package com.bruno.shoppingjava.client.domain;

import com.bruno.shoppingjava.invoice.domain.Invoice;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@Table(name = "client", schema = "shopping_cart")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String last_name;
  private String full_name;
  private String ruc;
  private String email;
  private String phone;
  private String address;
  private String status;

  // relationship with invoice
  @OneToMany(mappedBy = "client")
  private List<Invoice> invoices;
}
