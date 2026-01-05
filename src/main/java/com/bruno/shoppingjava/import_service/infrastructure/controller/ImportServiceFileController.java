package com.bruno.shoppingjava.import_service.infrastructure.controller;

import com.bruno.shoppingjava.import_service.application.CreateImportServiceFileUseCase;
import com.bruno.shoppingjava.import_service.application.GetImportServiceFileUseCase;
import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import com.bruno.shoppingjava.shared.infrastructure.helper.FileHandlerHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/import-service-files")
public class ImportServiceFileController {
  private final CreateImportServiceFileUseCase createImportServiceFileUseCase;
  private final GetImportServiceFileUseCase getImportServiceFileUseCase;

  @PostMapping
  public ResponseEntity<ImportServiceFileResponse> createImportServiceFile(@RequestPart MultipartFile file) {
    ImportFileWrapper fileWrapper = FileHandlerHelper.toImportFileWrapper(file);
    CreateImportServiceFileRequest request = CreateImportServiceFileRequest.builder()
      .file(fileWrapper)
      .build();
    ImportServiceFileResponse response = createImportServiceFileUseCase.create(request);
    return ResponseEntity.ok().body(response);
  }

  @GetMapping
  public List<ImportServiceFileResponse> getImportServiceFiles() {
    return getImportServiceFileUseCase.getAllImportServiceFiles();
  }
}
