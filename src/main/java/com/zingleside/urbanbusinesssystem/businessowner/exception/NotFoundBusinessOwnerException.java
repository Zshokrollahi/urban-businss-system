package com.zingleside.urbanbusinesssystem.businessowner.exception;

import com.zingleside.urbanbusinesssystem.error.exception.NotFoundException;

public class NotFoundBusinessOwnerException extends NotFoundException {
    public NotFoundBusinessOwnerException(String message) {
        super(message);
    }
}
