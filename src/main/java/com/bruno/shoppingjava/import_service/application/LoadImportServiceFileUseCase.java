package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.helper.ReadFileHelper;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoadImportServiceFileUseCase {

  public void processFile(ImportFileWrapper file, ImportServiceFile fileWrapper) {
    var reads = ReadFileHelper.recordsFromCSV(file.getFilePath());
    logger.info("File {} has {} records", file.getFilename(), reads.size());
    reads.forEach(read -> {
      logger.info("Processing record: {}", read);
    });
  }
}
