package com.bruno.shoppingjava.client.application.response;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.client.domain.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
  private Long id;
  private String name;
  private String lastName;
  private String fullName;
  private String ruc;
  private String email;
  private String phone;
  private String address;
  private String status;

  public static ClientResponse toResponse(Client client) {
    var status = Optional.ofNullable(client.getStatus())
      .filter(s -> s.equalsIgnoreCase(ClientStatus.ACTIVE.getDescription()))
      .map(s -> ClientStatus.ACTIVE.getDescription())
      .orElse(ClientStatus.INACTIVE.getDescription());

    return Optional.of(client)
      .map(c -> ClientResponse.builder()
        .id(c.getId())
        .name(c.getName())
        .fullName(c.getFullName())
        .lastName(c.getLastName())
        .ruc(c.getRuc())
        .email(c.getEmail())
        .phone(c.getPhone())
        .address(c.getAddress())
        .status(status)
        .build()
      ).orElse(null);
  }
}
