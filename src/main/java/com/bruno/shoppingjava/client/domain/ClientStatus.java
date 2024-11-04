package com.bruno.shoppingjava.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientStatus {
  ACTIVE (1, "Activo"),
  INACTIVE (2, "Inactivo");

  private final int priority;
  private final String description;

}
