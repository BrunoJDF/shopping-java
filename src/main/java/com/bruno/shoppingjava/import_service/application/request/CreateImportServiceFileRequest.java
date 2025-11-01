package com.bruno.shoppingjava.import_service.application.request;

import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateImportServiceFileRequest {
  private ImportFileWrapper file;
}
