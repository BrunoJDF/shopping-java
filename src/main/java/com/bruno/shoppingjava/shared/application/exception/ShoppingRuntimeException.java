package com.bruno.shoppingjava.shared.application.exception;

public class ShoppingRuntimeException extends RuntimeException {
  public ShoppingRuntimeException(String message) {
    super(String.format("Exception not cataloged: %s", message));
  }
}
