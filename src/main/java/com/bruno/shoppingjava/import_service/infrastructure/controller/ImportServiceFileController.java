package com.bruno.shoppingjava.import_service.infrastructure.controller;

import com.bruno.shoppingjava.import_service.application.CreateImportServiceFileUseCase;
import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.shared.infrastructure.helper.FileHandlerHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/import-service-files")
public class ImportServiceFileController {
  private final CreateImportServiceFileUseCase useCase;

  @PostMapping
  public ResponseEntity<ImportServiceFileResponse> createImportServiceFile(@RequestPart MultipartFile file) {
    var fileWrapper = FileHandlerHelper.toImportFileWrapper(file);
    var request = CreateImportServiceFileRequest.builder()
      .file(fileWrapper)
      .build();
    var response = useCase.create(request);
    return ResponseEntity.ok().body(response);
  }
}
