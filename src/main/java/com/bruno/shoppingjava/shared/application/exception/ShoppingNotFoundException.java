package com.bruno.shoppingjava.shared.application.exception;

public class ShoppingNotFoundException extends RuntimeException {
  public ShoppingNotFoundException(String domain) {
    super("Not found " + domain);
  }
}
