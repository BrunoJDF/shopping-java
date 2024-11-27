package com.bruno.shoppingjava.client.application.request;

import com.bruno.shoppingjava.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateClientRequest {
  private String name;
  private String lastName;
  private String ruc;
  private String email;
  private String phone;
  private String address;

  public Client toClientDomain() {
    return Optional.of(this)
      .map(client -> {
        String fullName = client.getName() + " " + client.getLastName();
        return Client.builder()
          .name(client.getName())
          .last_name(client.getLastName())
          .full_name(fullName)
          .ruc(client.getRuc())
          .email(client.getEmail())
          .phone(client.getPhone())
          .address(client.getAddress())
          .build();
      })
      .orElse(null);
  }
}
