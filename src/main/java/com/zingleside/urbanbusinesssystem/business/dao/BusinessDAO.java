package com.zingleside.urbanbusinesssystem.business.dao;

import com.zingleside.urbanbusinesssystem.business.entity.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessDAO {
  List<Business> selectAllBusinesses();

  Optional<Business> selectBusinessByID(Long id);

  Business insertBusiness(Business business);

  boolean existsById(long id);

  Business updateById(Business business);

  long deleteById(long id);
}
