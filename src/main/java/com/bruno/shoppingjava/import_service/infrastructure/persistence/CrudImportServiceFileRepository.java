package com.bruno.shoppingjava.import_service.infrastructure.persistence;

import com.bruno.shoppingjava.import_service.infrastructure.persistence.model.ImportServiceFileDAO;
import org.springframework.data.repository.CrudRepository;

public interface CrudImportServiceFileRepository extends CrudRepository<ImportServiceFileDAO, Long> {
}
