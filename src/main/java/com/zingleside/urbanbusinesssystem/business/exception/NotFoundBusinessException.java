package com.zingleside.urbanbusinesssystem.business.exception;

import com.zingleside.urbanbusinesssystem.error.exception.NotFoundException;

public class NotFoundBusinessException extends NotFoundException {
  public NotFoundBusinessException(String message) {
    super(message);
  }
}
