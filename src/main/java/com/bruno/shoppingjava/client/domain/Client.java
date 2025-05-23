package com.bruno.shoppingjava.client.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class Client {
  private Long id;
  private String name;
  private String lastName;
  private String fullName;
  private String ruc;
  private String email;
  private String phone;
  private String address;
  private ClientStatus status;
}
