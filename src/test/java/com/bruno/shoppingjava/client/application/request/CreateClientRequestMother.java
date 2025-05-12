package com.bruno.shoppingjava.client.application.request;

import com.bruno.shoppingjava.shared.mother.WordMother;

public class CreateClientRequestMother {

  public static CreateClientRequest random() {
    return CreateClientRequest.builder()
      .name(WordMother.random())
      .lastName(WordMother.random())
      .ruc(WordMother.random())
      .email(WordMother.random())
      .phone(WordMother.random())
      .address(WordMother.random())
      .build();
  }

}
