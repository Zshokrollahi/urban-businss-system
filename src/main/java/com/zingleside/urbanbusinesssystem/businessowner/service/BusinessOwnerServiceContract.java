package com.zingleside.urbanbusinesssystem.businessowner.service;

import com.zingleside.urbanbusinesssystem.businessowner.model.BusinessOwner;

import java.util.List;

public interface BusinessOwnerServiceContract {
  BusinessOwner create(BusinessOwner businessOwner);

  BusinessOwner update(BusinessOwner businessOwner);

  long deleteById(long id);

  List<BusinessOwner> findAll();

  BusinessOwner getById(long id);
}
