package com.bruno.shoppingjava.shared.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ImportFileContentTypeEnum {
  CSV("text/csv"),
  TXT("text/plain"),
  XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
  JSON("application/json"),
  XML("application/xml"),
  PDF("application/pdf"),
  OCTET_STREAM("application/octet-stream");

  private final String value;
}
