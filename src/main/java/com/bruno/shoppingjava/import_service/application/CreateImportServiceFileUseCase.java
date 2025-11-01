package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CreateImportServiceFileUseCase {
  private final ImportServiceFileRepository importServiceFileRepository;

  public ImportServiceFileResponse create(CreateImportServiceFileRequest request) {
    var domain = ImportServiceFile.builder()
      .filename(request.getFilename())
      .createdBy("system")
      .createdAt(OffsetDateTime.now())
      .build();
    var saved = importServiceFileRepository.save(domain);
    return ImportServiceFileResponse.toResponse(saved);
  }
}
