package com.bruno.shoppingjava.import_service.application;

import com.bruno.shoppingjava.import_service.application.helper.ReadFileHelper;
import com.bruno.shoppingjava.import_service.domain.ImportServiceFile;
import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import com.bruno.shoppingjava.shared.domain.StatusProcessEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoadImportServiceFileUseCase {
  private final ServiceRequestedUseCase serviceRequestedUseCase;

  public void processFile(ImportFileWrapper file, ImportServiceFile fileWrapper) {
    List<List<String>> records = ReadFileHelper.recordsFromCSV(file.getContent());
    logger.info("File {} has {} records", file.getFilename(), records.size());
    try {
      fileWrapper.setStatus(StatusProcessEnum.IN_PROGRESS);

    } catch (Exception e) {
      fileWrapper.setStatus(StatusProcessEnum.FAILED);
      logger.error("Error processing file: {}", file.getFilename(), e);
      throw new ShoppingRuntimeException("Error processing file: " + file.getFilename());
    }
  }
}
