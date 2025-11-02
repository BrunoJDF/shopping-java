package com.bruno.shoppingjava.import_service.infrastructure.controller;

import com.bruno.shoppingjava.import_service.application.CreateImportServiceFileUseCase;
import com.bruno.shoppingjava.import_service.application.ImportServiceFileUnitTestCase;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ImportServiceFileControllerTest extends ImportServiceFileUnitTestCase {

  @Mock
  private CreateImportServiceFileUseCase createImportServiceFileUseCase;
  @InjectMocks
  private ImportServiceFileController systemUnderTest;

  @Test
  @SneakyThrows
  void shouldCallUseCaseCreate() {
    MultipartFile file = mock(MultipartFile.class);
    ImportServiceFileResponse response =
      ImportServiceFileResponse.toResponse(ImportServiceFileMother.random());

    when(file.getInputStream())
      .thenReturn(mock(InputStream.class));

    when(createImportServiceFileUseCase.create(any()))
      .thenReturn(response);

    systemUnderTest.createImportServiceFile(file);

    verify(createImportServiceFileUseCase).create(any());
  }

  @Test
  @SneakyThrows
  void shouldCreateAndReturnResponse() {
    MultipartFile file = mock(MultipartFile.class);
    ImportServiceFile domain = ImportServiceFileMother.random();
    ImportServiceFileResponse response =
      ImportServiceFileResponse.toResponse(domain);

    when(file.getInputStream())
      .thenReturn(mock(InputStream.class));
    when(createImportServiceFileUseCase.create(any()))
      .thenReturn(response);

    var actualResponse = systemUnderTest.createImportServiceFile(file);

    assertEquals(response, actualResponse.getBody());
  }

}
