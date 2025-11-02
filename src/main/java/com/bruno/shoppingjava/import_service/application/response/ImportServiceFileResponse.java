package com.bruno.shoppingjava.import_service.application.response;

import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportServiceFileResponse {
  private long id;
  private String filename;
  private String status;

  public static ImportServiceFileResponse toResponse(ImportServiceFile saved) {
    return ImportServiceFileResponse.builder()
      .id(saved.getId())
      .filename(saved.getFilename())
      .status(saved.getStatus().getValue())
      .build();
  }
}
