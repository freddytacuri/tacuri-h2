package com.tacuri.controller;

import com.tacuri.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerValidationController {

  @ExceptionHandler(NotFoundException.class)
  ResponseEntity<Object> onBadRequestException() {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
