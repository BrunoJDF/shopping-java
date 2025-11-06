package com.bruno.shoppingjava.import_service.application.helper;

import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@UtilityClass
public class ReadFileHelper {

  public static final String DELIMITER = ",";

  public List<List<String>> recordsFromCSV(String filePath) {
    try {
      var a = Files.readAllLines(Paths.get(filePath));
      return a.stream()
        .map(line -> List.of(line.split(DELIMITER)))
        .toList();
    } catch (Exception e) {
      logger.error("Error reading CSV file at path: {}", filePath, e);
      throw new ShoppingRuntimeException("Error reading CSV file");
    }
  }
}
