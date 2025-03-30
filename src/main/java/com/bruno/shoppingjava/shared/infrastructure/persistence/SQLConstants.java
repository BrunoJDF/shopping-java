package com.bruno.shoppingjava.shared.infrastructure.persistence;

import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;

@UtilityClass
public class SQLConstants {
  @Value("${shopping-cart-properties.sql.schema-context}")
  public static final String SCHEMA = "shopping_cart";
}
