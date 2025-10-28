package com.bruno.shoppingjava.import_service.infrastructure.persistence.model;

import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = ImportServiceFileDAO.SQLImportService.TABLE_NAME)
public class ImportServiceFileDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLImportService.FILENAME)
  private String filename;
  @Column(name = SQLImportService.CREATED_AT)
  private OffsetDateTime createdAt;
  @Column(name = SQLImportService.UPDATED_AT)
  private OffsetDateTime updatedAt;

  public static ImportServiceFileDAO fromDomain(ImportServiceFile importServiceFile) {
    return ImportServiceFileDAO.builder()
      .id(importServiceFile.getId())
      .filename(importServiceFile.getFilename())
      .createdAt(importServiceFile.getCreatedAt())
      .updatedAt(importServiceFile.getUpdatedAt())
      .build();
  }

  public ImportServiceFile toDomain() {
    return ImportServiceFile.builder()
      .id(this.id)
      .filename(this.filename)
      .createdAt(this.createdAt)
      .updatedAt(this.updatedAt)
      .build();
  }


  static class SQLImportService {
    static final String TABLE_NAME = "import_service";

    private SQLImportService() {
      throw new IllegalStateException("Utility class");
    }

    static final String FILENAME = "filename";
    static final String CREATED_AT = "created_at";
    static final String UPDATED_AT = "updated_at";
  }
}
