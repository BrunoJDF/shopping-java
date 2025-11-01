package com.bruno.shoppingjava.import_service.domain;

import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

import java.time.OffsetDateTime;
import java.util.List;

public class ImportServiceFileMother {
  public static ImportServiceFile random() {
    return ImportServiceFile.builder()
      .id(BigDecimalMother.random().longValue())
      .filename(WordMother.random() + "_import_file.csv")
      .createdBy("system")
      .createdAt(OffsetDateTime.now())
      .updatedBy("system")
      .updatedAt(OffsetDateTime.now())
      .build();
  }

  public static List<ImportServiceFile> randomList() {
    return List.of(
      random(),
      random(),
      random()
    );
  }
}
