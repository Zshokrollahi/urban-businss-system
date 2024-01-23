package com.zingleside.urbanbusinesssystem.error.api;

import com.zingleside.urbanbusinesssystem.error.exception.ConflictException;
import com.zingleside.urbanbusinesssystem.error.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorManagerController {
  public record ExceptionResponse(String errorCode, String errorMessage, String requestedURI) {}

  @ExceptionHandler(ConflictException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public @ResponseBody ExceptionResponse handleEmployeeNotFound(
      ConflictException exception, final HttpServletRequest request) {
    return new ExceptionResponse(
        HttpStatus.CONFLICT.name(), exception.getMessage(), request.getRequestURI());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ExceptionResponse handleEmployeeNotFound(
      NotFoundException exception, final HttpServletRequest request) {
    return new ExceptionResponse(
        HttpStatus.NOT_FOUND.name(), exception.getMessage(), request.getRequestURI());
  }
}
