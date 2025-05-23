package com.bruno.shoppingjava.client.infrastructure.persistence.model;

import com.bruno.shoppingjava.client.domain.ClientStatus;
import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

public class ClientDAOMother {
  public static ClientDAO random() {
    String name = WordMother.random();
    String lastName = WordMother.random();
    return ClientDAO.builder()
      .id(BigDecimalMother.random().longValue())
      .name(name)
      .lastName(lastName)
      .fullName(name + " " + lastName)
      .ruc("107362605225")
      .email(WordMother.random() + "@example.com")
      .phone(BigDecimalMother.random().toString())
      .address(WordMother.random())
      .status(ClientStatus.ACTIVE)
      .build();
  }

}
