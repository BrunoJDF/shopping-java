package com.bruno.shoppingjava.shared.infrastructure.helper;

import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import com.bruno.shoppingjava.shared.domain.ImportFileWrapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@UtilityClass
public class FileHandlerHelper {

  public ImportFileWrapper toImportFileWrapper(MultipartFile file) {
    try (var inputStream = file.getInputStream()) {
      byte[] bytes = inputStream.readAllBytes();
      String filename = file.getOriginalFilename();
      long size = file.getSize();
      String contentType = file.getContentType();
      return ImportFileWrapper.builder()
        .content(bytes)
        .filename(filename)
        .size(size)
        .contentType(contentType)
        .build();
    } catch (IOException e) {
      LOGGER.error("Error reading file: {}", file.getOriginalFilename(), e);
      throw new ShoppingRuntimeException("Error reading file: " + file.getOriginalFilename());
    }
  }
}
