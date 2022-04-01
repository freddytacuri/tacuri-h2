package com.tacuri.controller;

import com.tacuri.domain.dto.ErrorDto;
import com.tacuri.exceptions.InternalErrorException;
import com.tacuri.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class HandlerValidationController {

  @ExceptionHandler(NotFoundException.class)
  ResponseEntity<Object> onBadRequestException() {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  ErrorDto onMethodArgumentNotValidException(MethodArgumentTypeMismatchException exception) {
    ErrorDto error = ErrorDto.builder().status(HttpStatus.BAD_REQUEST.value())
        .message("Bad request").build();
    error.getErrors().add(String.format("Validation error in field %s: %s", exception.getName(),
        exception.getMessage()));
    return error;
  }

  @ExceptionHandler(InternalErrorException.class)
  ResponseEntity<Object> onInternalErrorException() {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
