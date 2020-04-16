package org.example.domain.exceptions;

public class InvalidParamsException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidParamsException(String message) {
    super(message);
  }

}