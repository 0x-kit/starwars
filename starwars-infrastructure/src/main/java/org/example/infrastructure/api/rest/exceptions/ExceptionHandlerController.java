package org.example.infrastructure.api.rest.exceptions;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.example.domain.exceptions.InstanceNotFoundException;
import org.example.domain.exceptions.InvalidParamsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InstanceNotFoundException.class)
  public void springHandleNotFound(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler(InvalidParamsException.class)
  public void springHandleBadRequest(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }

}