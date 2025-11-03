package com.bruno.shoppingjava.import_service.infrastructure.persistence;

import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFileRepository;
import com.bruno.shoppingjava.import_service.infrastructure.persistence.model.ImportServiceFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImportServiceFileRepositoryImpl implements ImportServiceFileRepository {
  private final CrudImportServiceFileRepository crudImportServiceFileRepository;

  @Override
  public ImportServiceFile save(ImportServiceFile importServiceFile) {
    ImportServiceFileDAO dao = ImportServiceFileDAO.fromDomain(importServiceFile);
    ImportServiceFileDAO saved = crudImportServiceFileRepository.save(dao);
    return saved.toDomain();
  }

  @Override
  public List<ImportServiceFile> findAll() {
    List<ImportServiceFileDAO> importServiceFiles = (List<ImportServiceFileDAO>) crudImportServiceFileRepository.findAll();
    return importServiceFiles.stream().map(ImportServiceFileDAO::toDomain).toList();
  }
}
