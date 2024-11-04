package com.bruno.shoppingjava.client.application.response;

import com.bruno.shoppingjava.client.domain.Client;
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
  private String fullName;
  private String lastName;
  private String ruc;
  private String email;
  private String phone;
  private String address;
  private String status;

  public static ClientResponse toResponse(Client client) {
    return Optional.ofNullable(client)
      .map(c -> ClientResponse.builder()
        .id(c.getId())
        .name(c.getName())
        .fullName(c.getFull_name())
        .lastName(c.getLast_name())
        .ruc(c.getRuc())
        .email(c.getEmail())
        .phone(c.getPhone())
        .address(c.getAddress())
        .status(c.getStatus())
        .build()
      ).orElse(null);
  }
}
