package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequestMother;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateImportServiceFileUseCaseTest extends ImportServiceFileUnitTestCase {

  @Mock
  private ImportServiceFileRepository importServiceFileRepository;
  @InjectMocks
  private CreateImportServiceFileUseCase systemUnderTest;

  @Test
  void create() {
    var request = CreateImportServiceFileRequestMother.random();
    var domain = ImportServiceFileMother.random();

    when(importServiceFileRepository.save(any()))
      .thenReturn(domain);

    systemUnderTest.create(request);

    verify(importServiceFileRepository).save(any());
  }
}
