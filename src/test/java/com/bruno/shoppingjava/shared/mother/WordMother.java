package com.bruno.shoppingjava.shared.mother;

import com.bruno.shoppingjava.shared.MotherCreator;

public class WordMother {
  public static String random() {
    return MotherCreator.random().lorem().word();
  }
}
