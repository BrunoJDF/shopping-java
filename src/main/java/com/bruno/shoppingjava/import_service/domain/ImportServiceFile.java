package com.bruno.shoppingjava.import_service.domain;

import com.bruno.shoppingjava.shared.domain.StatusProcessEnum;
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
  private StatusProcessEnum status;
  private String createdBy;
  private OffsetDateTime createdAt;
  private String updatedBy;
  private OffsetDateTime updatedAt;
  private long totalRecords;
  private String errorMessage;
}
