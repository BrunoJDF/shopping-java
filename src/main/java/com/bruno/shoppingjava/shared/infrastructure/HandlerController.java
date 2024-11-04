package com.bruno.shoppingjava.shared.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HandlerController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception e) {
    LOGGER.error("Error: ", e);
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
