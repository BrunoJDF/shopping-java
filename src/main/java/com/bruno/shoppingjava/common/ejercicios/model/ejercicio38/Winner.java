package com.bruno.shoppingjava.common.ejercicios.model.ejercicio38;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Winner {
  private String id;
  private String email;
  private String status;
}
