package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequest;
import com.bruno.shoppingjava.import_service.application.request.CreateImportServiceFileRequestMother;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import com.bruno.shoppingjava.service_requested.application.CreateServiceRequestedUseCase;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class LoadImportServiceFileUseCaseTest extends ImportServiceFileUnitTestCase {

  @Mock
  private CreateServiceRequestedUseCase createServiceRequestedUseCase;
  @InjectMocks
  private LoadImportServiceFileUseCase systemUnderTest;

  @Test
  void shouldProcessFileSuccessfully() {
    CreateImportServiceFileRequest request = CreateImportServiceFileRequestMother.random();
    ImportFileWrapper file = request.getFile();
    ImportServiceFile importServiceFile = ImportServiceFileMother.fromCreateRequest(request);

    systemUnderTest.processFile(file, importServiceFile);
    
    verify(createServiceRequestedUseCase).createServiceRequestedFromImport(any());
  }
}
