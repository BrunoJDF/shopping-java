package com.bruno.shoppingjava.client.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientStatus;
import com.bruno.shoppingjava.invoice.infrastructure.persistence.model.InvoiceDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = ClientDAO.SQLClient.TABLE_NAME)
public class ClientDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLClient.NAME)
  private String name;
  @Column(name = SQLClient.LAST_NAME)
  private String lastName;
  @Column(name = SQLClient.FULL_NAME)
  private String fullName;
  @Column(name = SQLClient.RUC)
  private String ruc;
  @Column(name = SQLClient.EMAIL)
  private String email;
  @Column(name = SQLClient.PHONE)
  private String phone;
  @Column(name = SQLClient.ADDRESS)
  private String address;
  @Column(name = SQLClient.STATUS)
  @Enumerated(EnumType.STRING)
  private ClientStatus status;

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

  static class SQLClient {
    static final String TABLE_NAME = "client";

    private SQLClient() {
      throw new IllegalStateException("Utility class");
    }

    static final String NAME = "name";
    static final String LAST_NAME = "last_name";
    static final String FULL_NAME = "full_name";
    static final String RUC = "ruc";
    static final String EMAIL = "email";
    static final String PHONE = "phone";
    static final String ADDRESS = "address";
    static final String STATUS = "status";
  }
}
