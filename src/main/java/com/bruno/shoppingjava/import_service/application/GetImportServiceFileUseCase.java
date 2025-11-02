package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetImportServiceFileUseCase {

  private final ImportServiceFileRepository importServiceFileRepository;

  public List<ImportServiceFileResponse> getAllImportServiceFiles() {
    return importServiceFileRepository.findAll().stream()
      .map(ImportServiceFileResponse::toResponse)
      .toList();
  }
}
