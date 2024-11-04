package com.bruno.shoppingjava.shared.application.exception;

public class ShoppingNotFoundException extends RuntimeException {
  public <T> ShoppingNotFoundException(Class<T> domain) {
    super("Not found " + domain.getSimpleName());
  }
}
