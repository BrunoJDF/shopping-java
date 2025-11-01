package com.bruno.shoppingjava.import_service.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateImportServiceFileRequest {
  private String filename;
  private byte[] content;
}
