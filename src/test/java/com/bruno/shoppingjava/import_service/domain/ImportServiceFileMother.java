package com.bruno.shoppingjava.import_service.domain;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.shared.domain.StatusProcessEnum;
import com.bruno.shoppingjava.shared.mother.BigDecimalMother;
import com.bruno.shoppingjava.shared.mother.WordMother;

import java.util.List;

public class ImportServiceFileMother {
  public static ImportServiceFile random() {
    return ImportServiceFile.builder()
      .id(BigDecimalMother.random().longValue())
      .filename(WordMother.random() + "_import_file.csv")
      .status(StatusProcessEnum.PENDING)
      .build();
  }

  public static List<ImportServiceFile> randomList() {
    return List.of(
      random(),
      random(),
      random()
    );
  }

  public static ImportServiceFile fromCreateRequest(
    CreateImportServiceFileRequest request
  ) {
    return ImportServiceFile.builder()
      .filename(request.getFile().getFilename())
      .status(StatusProcessEnum.PENDING)
      .build();
  }

  public static ImportServiceFile withId(ImportServiceFile domain) {
    return ImportServiceFile.builder()
      .id(BigDecimalMother.random().longValue())
      .filename(domain.getFilename())
      .status(domain.getStatus())
      .build();
  }
}
