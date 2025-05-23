package com.bruno.shoppingjava.shared.mother;

import com.bruno.shoppingjava.shared.MotherCreator;

import java.math.BigDecimal;

public class BigDecimalMother {
  public static BigDecimal random() {
    double doubleVal = MotherCreator.random()
      .number()
      .randomDouble(3, 0, Integer.MAX_VALUE);
    BigDecimal bigDecimalVal = BigDecimal.valueOf(doubleVal);
    return new BigDecimal(bigDecimalVal.toString());
  }
}
