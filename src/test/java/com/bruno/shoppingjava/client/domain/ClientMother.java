package com.bruno.shoppingjava.client.domain;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

import java.util.Random;

public class ClientMother {

  public static Client random() {
    String name = WordMother.random();
    String lastName = WordMother.random();
    String fullName = name + " " + lastName;
    String ruc = generateCodeByLength(11);
    return Client.builder()
      .id(BigDecimalMother.random().longValue())
      .name(name)
      .lastName(lastName)
      .fullName(fullName)
      .ruc(ruc)
      .email(WordMother.random() + "@example.com")
      .phone(generateCodeByLength(9))
      .address(WordMother.random() + " Street")
      .status(ClientStatus.ACTIVE) // Assuming ACTIVE is a valid status
      .build();
  }

  private static String generateCodeByLength(int i) {
    // Randomly generate a string of digits of length i
    Random random = new Random();
    StringBuilder code = new StringBuilder();
    for (int j = 0; j < i; j++) {
      code.append(random.nextInt(10)); // Append a random digit (0-9)
    }
    return code.toString();
  }

}
