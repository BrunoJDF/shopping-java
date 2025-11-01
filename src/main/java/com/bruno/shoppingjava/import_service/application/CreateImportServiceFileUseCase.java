package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CreateImportServiceFileUseCase {
  private final ImportServiceFileRepository importServiceFileRepository;

  public ImportServiceFileResponse create(CreateImportServiceFileRequest request) {
    ImportFileWrapper file = request.getFile();
    this.verifyContentIsValid(file);
    var domain = ImportServiceFile.builder()
      .filename(file.getFilename())
      .createdBy("system")
      .createdAt(OffsetDateTime.now())
      .build();
    var saved = importServiceFileRepository.save(domain);
    return ImportServiceFileResponse.toResponse(saved);
  }

  private void verifyContentIsValid(ImportFileWrapper request) {
    if (request.getContentType() == null || request.getContentType().isBlank()) {
      throw new IllegalArgumentException("File content type is invalid");
    }
    // must be csv file
    if (!request.getContentType().equals("text/csv")) {
      throw new IllegalArgumentException("File content type must be text/csv");
    }
  }
}
