package com.bruno.shoppingjava.shared.domain;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ImportFileWrapperMother {
  private static final java.util.Random RANDOM = new java.util.Random(42);

  public static ImportFileWrapper random() {
    String extension = randomExtension();
    String contentType = getContenTypeFromExtension(extension);
    return ImportFileWrapper.builder()
      .filename("file_" + Math.random() + "." + extension)
      .content(new byte[]{1, 2, 3, 4, 5})
      .contentType(contentType)
      .size(5L)
      .build();
  }

  private static String getContenTypeFromExtension(String extension) {
    return switch (extension) {
      case "txt" -> "text/plain";
      case "csv" -> "text/csv";
      case "json" -> "application/json";
      case "xml" -> "application/xml";
      case "xlsx" -> "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
      case "pdf" -> "application/pdf";
      default -> "application/octet-stream";
    };
  }

  private static String randomExtension() {
    String[] extensions = {"txt", "csv", "json", "xml", "xlsx", "pdf"};
    int index = RANDOM.nextInt(extensions.length);
    return extensions[index];
  }
}
