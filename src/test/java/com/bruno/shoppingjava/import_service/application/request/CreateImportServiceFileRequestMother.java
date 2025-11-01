package com.bruno.shoppingjava.import_service.application.request;


import com.bruno.shoppingjava.shared.mother.WordMother;

public class CreateImportServiceFileRequestMother {
  public static CreateImportServiceFileRequest random() {
    return CreateImportServiceFileRequest.builder()
      .filename("file_" + System.currentTimeMillis() + "_" + WordMother.random() + ".txt")
      .content(WordMother.random().getBytes())
      .build();
  }
}
