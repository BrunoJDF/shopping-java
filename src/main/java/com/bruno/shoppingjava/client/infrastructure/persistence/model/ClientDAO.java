package com.bruno.shoppingjava.client.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
import jakarta.persistence.Column;
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
public class ClientDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "full_name")
  private String fullName;
  private String ruc;
  private String email;
  private String phone;
  private String address;
  private String status;

  // relationship with invoice
  @OneToMany(mappedBy = "client")
  private List<InvoiceDAO> invoices;

  public static ClientDAO fromDomain(Client client) {
    return ClientDAO.builder()
      .id(client.getId())
      .name(client.getName())
      .lastName(client.getLastName())
      .fullName(client.getFullName())
      .ruc(client.getRuc())
      .email(client.getEmail())
      .phone(client.getPhone())
      .address(client.getAddress())
      .status(client.getStatus())
      .build();
  }

  public Client toDomain() {
    return Client.builder()
      .id(id)
      .name(name)
      .lastName(lastName)
      .fullName(fullName)
      .ruc(ruc)
      .email(email)
      .phone(phone)
      .address(address)
      .status(status)
      .build();
  }
}
