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
    var contentType = switch (extension) {
      case "csv" -> ImportFileContentTypeEnum.CSV;
      case "txt" -> ImportFileContentTypeEnum.TXT;
      case "json" -> ImportFileContentTypeEnum.JSON;
      case "xml" -> ImportFileContentTypeEnum.XML;
      case "xlsx" -> ImportFileContentTypeEnum.XLSX;
      case "pdf" -> ImportFileContentTypeEnum.PDF;
      default -> ImportFileContentTypeEnum.OCTET_STREAM;
    };
    return contentType.getValue();
  }

  private static String randomExtension() {
    String[] extensions = {"txt", "csv", "json", "xml", "xlsx", "pdf"};
    int index = RANDOM.nextInt(extensions.length);
    return extensions[index];
  }

  public static ImportFileWrapper withContentType(ImportFileContentTypeEnum contentType) {
    String extension = switch (contentType) {
      case CSV -> "csv";
      case TXT -> "txt";
      case XLSX -> "xlsx";
      case JSON -> "json";
      case XML -> "xml";
      case PDF -> "pdf";
      default -> "bin";
    };
    return ImportFileWrapper.builder()
      .filename("file_" + Math.random() + "." + extension)
      .content(new byte[]{1, 2, 3, 4, 5})
      .contentType(contentType.getValue())
      .size(5L)
      .build();
  }
}
