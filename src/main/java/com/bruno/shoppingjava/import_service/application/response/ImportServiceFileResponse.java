package com.bruno.shoppingjava.import_service.application.response;

import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportServiceFileResponse {
  private long id;
  private String filename;
  private String status;
  private OffsetDateTime createdAt;
  private String createdBy;
  private OffsetDateTime updatedAt;
  private String updatedBy;

  public static ImportServiceFileResponse toResponse(ImportServiceFile saved) {
    return ImportServiceFileResponse.builder()
      .id(saved.getId())
      .filename(saved.getFilename())
      .status(saved.getStatus().getValue())
      .build();
  }
}
