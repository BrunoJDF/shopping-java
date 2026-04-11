package com.bruno.shoppingjava.service_requested.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServiceStatus {
  PENDING(1, "Pending"),
  IN_PROGRESS(2, "In Progress"),
  COMPLETED(3, "Completed"),
  CANCELLED(4, "Cancelled");

  private final int code;
  private final String description;
}
