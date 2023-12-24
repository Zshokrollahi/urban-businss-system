package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessDAO {
    List<Business> selectAllBusinesses();
    Optional<Business> selectBusinessByID();
}
