package com.bruno.shoppingjava.shared.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {
  private int status;
  private String message;

  public static ResponseError fromMessage(String exceptionMessage, int status) {
    return ResponseError.builder()
      .status(status)
      .message(exceptionMessage)
      .build();
  }
}
