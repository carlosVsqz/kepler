package com.escod.kepler.controller.exception;

import com.escod.kepler.data.ResponseException;
import com.escod.kepler.exception.CreateUserException;
import io.jmix.core.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ValidationControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  protected Messages messages;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    return this.handleExceptionInternal(ex, null, headers, status, request);
  }

  @ExceptionHandler(CreateUserException.class)
  public ResponseEntity<Object> handleException(CreateUserException ex, WebRequest request) {
    var status = HttpStatus.BAD_REQUEST;

    String username = ex.getMessage();
    String msg = messages.getMessage("com.escod.kepler.application.user.exist");

    return this.handleExceptionInternal(ex, new ResponseException(status.value(), String.format(msg, username)), new HttpHeaders(), status, request);
  }
}
