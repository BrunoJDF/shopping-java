package com.bruno.shoppingjava.import_service.infrastructure.persistence;

import com.bruno.shoppingjava.import_service.application.ImportServiceFileUnitTestCase;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileMother;
import com.bruno.shoppingjava.import_service.infrastructure.persistence.model.ImportServiceFileDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ImportServiceFileRepositoryImplTest extends ImportServiceFileUnitTestCase {

  @Mock
  private CrudImportServiceFileRepository crudImportServiceFileRepository;

  @InjectMocks
  private ImportServiceFileRepositoryImpl systemUnderTest;

  @Test
  void shouldSaveImportServiceFile() {
    var domain = ImportServiceFileMother.random();
    var dao = ImportServiceFileDAO.fromDomain(domain);

    when(crudImportServiceFileRepository.save(any()))
      .thenReturn(dao);

    systemUnderTest.save(domain);

    verify(crudImportServiceFileRepository).save(any());
  }

  @Test
  void shouldReturnSavedImportServiceFile() {
    var domain = ImportServiceFileMother.random();
    var dao = ImportServiceFileDAO.fromDomain(domain);

    when(crudImportServiceFileRepository.save(any()))
      .thenReturn(dao);

    var saved = systemUnderTest.save(domain);

    assertEquals(domain, saved);
  }

  @Test
  void shouldFindAllImportServiceFiles() {
    systemUnderTest.findAll();

    verify(crudImportServiceFileRepository).findAll();
  }

  @Test
  void shouldReturnAllImportServiceFiles() {
    var domain = ImportServiceFileMother.randomList();
    var daoList = domain.stream()
      .map(ImportServiceFileDAO::fromDomain)
      .toList();

    when(crudImportServiceFileRepository.findAll())
      .thenReturn(daoList);

    var found = systemUnderTest.findAll();

    assertIterableEquals(domain, found);
  }
}
