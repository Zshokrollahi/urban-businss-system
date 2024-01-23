package com.zingleside.urbanbusinesssystem.businessowner.exception;

import com.zingleside.urbanbusinesssystem.error.exception.ConflictException;

public class BusinessOwnerNationalCodeConflictException extends ConflictException {
  public BusinessOwnerNationalCodeConflictException() {
    super("مالک کسب و کاری با این کد ملی قبلا ثبت شده است");
  }
}
