package com.zingleside.urbanbusinesssystem.businessowner.dao;

import com.zingleside.urbanbusinesssystem.businessowner.model.BusinessOwner;

import java.util.List;
import java.util.Optional;

public interface BusinessOwnerDAO {

  boolean existsByNationalCode(String nationalCode);

  BusinessOwner insertNewOwner(BusinessOwner businessOwner);

  BusinessOwner updateById(BusinessOwner businessOwner);

  boolean existsById(long id);

  long deleteById(long id);

  List<BusinessOwner> getAll();

  Optional<BusinessOwner> getById(long id);
}
