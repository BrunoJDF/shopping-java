package com.bruno.shoppingjava.import_service.domain;

import java.util.List;

public interface ImportServiceFileRepository {
  ImportServiceFile save(ImportServiceFile importServiceFile);
  
  List<ImportServiceFile> findAll();
}
