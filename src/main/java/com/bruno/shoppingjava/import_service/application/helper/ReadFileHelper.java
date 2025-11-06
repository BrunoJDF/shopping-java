package com.bruno.shoppingjava.import_service.application.helper;

import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@UtilityClass
public class ReadFileHelper {

  public static final String DELIMITER = ",";

  public List<List<String>> recordsFromCSV(byte[] filePath) {
    List<List<String>> records = new ArrayList<>();
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(filePath);
    try (BufferedReader res = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8))) {
      String line;
      while ((line = res.readLine()) != null) {
        String[] values = line.split(DELIMITER);
        records.add(List.of(values));
      }
      return records;
    } catch (Exception e) {
      logger.error("Error reading CSV file at path: {}", filePath, e);
      throw new ShoppingRuntimeException("Error reading CSV file");
    }
  }
}
