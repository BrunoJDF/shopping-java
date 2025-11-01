package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequestMother;
import com.bruno.shoppingjava.import_service.application.response.ImportServiceFileResponse;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateImportServiceFileUseCaseTest extends ImportServiceFileUnitTestCase {

  @Mock
  private ImportServiceFileRepository importServiceFileRepository;
  @InjectMocks
  private CreateImportServiceFileUseCase systemUnderTest;

  @Test
  void createShouldCallRepositorySave() {
    var request = CreateImportServiceFileRequestMother.random();
    var domain = ImportServiceFileMother.random();

    when(importServiceFileRepository.save(any()))
      .thenReturn(domain);

    systemUnderTest.create(request);

    verify(importServiceFileRepository).save(any());
  }

  @Test
  void createShouldReturnResponse() {
    var request = CreateImportServiceFileRequestMother.random();
    var domain = ImportServiceFileMother.random();

    when(importServiceFileRepository.save(any()))
      .thenReturn(domain);

    var response = systemUnderTest.create(request);

    ImportServiceFileResponse expected = ImportServiceFileResponse.toResponse(domain);
    assertEquals(expected, response);
  }
}
