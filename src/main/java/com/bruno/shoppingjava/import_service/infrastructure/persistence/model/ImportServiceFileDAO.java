package com.bruno.shoppingjava.import_service.infrastructure.persistence.model;

import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.shared.domain.StatusProcessEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = ImportServiceFileDAO.SQLImportService.TABLE_NAME)
public class ImportServiceFileDAO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = SQLImportService.FILENAME)
  private String filename;

  @Enumerated(EnumType.STRING)
  @Column(name = SQLImportService.STATUS)
  private StatusProcessEnum status;

  @CreatedBy
  @Column(name = SQLImportService.CREATED_BY)
  private String createdBy;

  @CreatedDate
  @Column(name = SQLImportService.CREATED_AT)
  private Instant createdAt;

  @LastModifiedBy
  @Column(name = SQLImportService.UPDATED_BY)
  private String updatedBy;

  @LastModifiedDate
  @Column(name = SQLImportService.UPDATED_AT)
  private Instant updatedAt;
  @Column(name = SQLImportService.TOTAL_RECORDS)
  private long totalRecords;
  @Column(name = SQLImportService.ERROR_MESSAGE)
  private String errorMessage;

  public static ImportServiceFileDAO fromDomain(ImportServiceFile importServiceFile) {
    return ImportServiceFileDAO.builder()
      .id(importServiceFile.getId())
      .filename(importServiceFile.getFilename())
      .status(importServiceFile.getStatus())
      .totalRecords(importServiceFile.getTotalRecords())
      .errorMessage(importServiceFile.getErrorMessage())
      .build();
  }

  public ImportServiceFile toDomain() {
    return ImportServiceFile.builder()
      .id(this.id)
      .filename(this.filename)
      .status(this.status)
      .totalRecords(this.totalRecords)
      .errorMessage(this.errorMessage)
      .build();
  }


  static class SQLImportService {
    static final String TABLE_NAME = "import_service_file";

    private SQLImportService() {
      throw new IllegalStateException("Utility class");
    }

    static final String FILENAME = "filename";
    static final String STATUS = "status";
    static final String CREATED_BY = "created_by";
    static final String CREATED_AT = "created_at";
    static final String UPDATED_BY = "updated_by";
    static final String UPDATED_AT = "updated_at";
    static final String TOTAL_RECORDS = "total_records";
    static final String ERROR_MESSAGE = "error_message";
  }
}
