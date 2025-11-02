package com.bruno.shoppingjava.shared.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusProcessEnum {
  PENDING("PENDING"),
  IN_PROGRESS("IN_PROGRESS"),
  COMPLETED("COMPLETED"),
  FAILED("FAILED");

  private final String value;
}
