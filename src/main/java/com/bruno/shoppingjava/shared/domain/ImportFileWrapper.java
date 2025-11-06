package com.bruno.shoppingjava.shared.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImportFileWrapper {
  private String filename;
  private byte[] content;
  private String contentType;
  private long size;
}
