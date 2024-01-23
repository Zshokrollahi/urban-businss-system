package com.zingleside.urbanbusinesssystem.business.service;

import com.zingleside.urbanbusinesssystem.business.entity.Business;

import java.util.List;

public interface BusinessServiceContract {
  List<Business> findAll();

  Business update(Business business);

  long deleteById(long id);

  Business getById(long id);

  Business create(Business business);
}
