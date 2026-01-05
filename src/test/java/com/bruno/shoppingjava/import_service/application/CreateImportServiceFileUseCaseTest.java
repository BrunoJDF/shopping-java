package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequestMother;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import com.bruno.shoppingjava.shared.domain.ImportFileContentTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateImportServiceFileUseCaseTest extends ImportServiceFileUnitTestCase {

  @Mock
  private ImportServiceFileRepository importServiceFileRepository;
  @Mock
  private LoadImportServiceFileUseCase loadImportServiceFileUseCase;
  @InjectMocks
  private CreateImportServiceFileUseCase systemUnderTest;

  @Test
  void createShouldCallRepositorySave() {
    ImportFileContentTypeEnum contentTypeEnum = ImportFileContentTypeEnum.CSV;
    CreateImportServiceFileRequest request =
      CreateImportServiceFileRequestMother.withFileType(contentTypeEnum);
    ImportServiceFile domain =
      ImportServiceFileMother.fromCreateRequest(request);
    ImportServiceFile savedDomain = ImportServiceFileMother.withId(domain);

    doNothing().when(loadImportServiceFileUseCase)
      .processFile(request.getFile(), domain);
    when(importServiceFileRepository.save(any()))
      .thenReturn(savedDomain);

    systemUnderTest.create(request);

    verify(importServiceFileRepository).save(any());
  }

  @Test
  void createShouldReturnResponse() {
    ImportFileContentTypeEnum contentTypeEnum = ImportFileContentTypeEnum.CSV;
    CreateImportServiceFileRequest request =
      CreateImportServiceFileRequestMother.withFileType(contentTypeEnum);
    ImportServiceFile domain = ImportServiceFileMother.random();

    when(importServiceFileRepository.save(any()))
      .thenReturn(domain);

    var response = systemUnderTest.create(request);

    ImportServiceFileResponse expected = ImportServiceFileResponse.toResponse(domain);
    assertEquals(expected, response);
  }
}
