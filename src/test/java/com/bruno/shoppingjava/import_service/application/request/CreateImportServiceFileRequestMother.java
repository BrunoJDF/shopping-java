package com.bruno.shoppingjava.import_service.application.request;


import com.bruno.shoppingjava.shared.domain.ImportFileWrapperMother;

public class CreateImportServiceFileRequestMother {
  public static CreateImportServiceFileRequest random() {
    return CreateImportServiceFileRequest.builder()
      .file(ImportFileWrapperMother.random())
      .build();
  }
}
