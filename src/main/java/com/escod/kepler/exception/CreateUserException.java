package com.escod.kepler.exception;

public class CreateUserException extends Exception {
  public CreateUserException() {
    super();
  }

  public CreateUserException(String message) {
    super(message);
  }

  public CreateUserException(String message, Throwable cause) {
    super(message, cause);
  }
}
