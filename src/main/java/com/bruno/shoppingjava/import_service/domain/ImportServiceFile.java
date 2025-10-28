package com.bruno.shoppingjava.import_service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class ImportServiceFile {
  private Long id;
  private String filename;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
