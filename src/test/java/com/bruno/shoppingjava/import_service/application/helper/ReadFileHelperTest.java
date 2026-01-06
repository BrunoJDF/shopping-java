package com.bruno.shoppingjava.import_service.application.helper;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadFileHelperTest {

  @Test
  @SneakyThrows
  void recordsFromCSV() {
    String pathFile = "src/main/resources/service-demo.csv";
    Path path = Path.of(pathFile);
    byte[] file = Files.readAllBytes(path);

    var content = ReadFileHelper.recordsFromCSV(file);

    assertNotNull(content);
  }
}
