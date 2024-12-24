package com.bruno.shoppingjava.shared.infrastructure;

import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import com.bruno.shoppingjava.shared.application.response.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HandlerControllerAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseError> handleException(Exception e) {
    LOGGER.error("Error: ", e);
    ResponseError errorResponse = ResponseError
      .fromMessage(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.badRequest()
      .body(errorResponse);
  }

  @ExceptionHandler(ShoppingNotFoundException.class)
  public ResponseEntity<ResponseError> handleShoppingNotFoundException(ShoppingNotFoundException e) {
    LOGGER.error("Error: ", e);
    ResponseError errorResponse = ResponseError
      .fromMessage(e.getMessage(), HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body(errorResponse);
  }
}
