package com.zingleside.urbanbusinesssystem.business.service;

import com.zingleside.urbanbusinesssystem.business.dao.BusinessDAO;
import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.business.exception.NotFoundBusinessException;
import com.zingleside.urbanbusinesssystem.businessowner.dao.BusinessOwnerDAO;
import com.zingleside.urbanbusinesssystem.businessowner.exception.NotFoundBusinessOwnerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService implements BusinessServiceContract {
  private final BusinessDAO businessDAO;
  private final BusinessOwnerDAO businessOwnerDAO;

  @Autowired
  public BusinessService(BusinessDAO businessDAO, BusinessOwnerDAO businessOwnerDAO) {
    this.businessDAO = businessDAO;
    this.businessOwnerDAO = businessOwnerDAO;
  }

  @Override
  public List<Business> findAll() {
    return businessDAO.selectAllBusinesses();
  }

  @Override
  public Business update(Business business) {
    if (isNotExistsBusiness(business.id()))
      throw new NotFoundBusinessException(
          "کسب و کاری با شناسه %d یافت نشد".formatted(business.id()));
    if (isNotExistsBusinessOwner(business.businessOwnerId()))
      throw new NotFoundBusinessOwnerException(
          "صاحب کسب کاری با شناسه %d یافت نشد".formatted(business.businessOwnerId()));
    return businessDAO.updateById(business);
  }

  private boolean isNotExistsBusinessOwner(long businessOwnerId) {
    return !businessOwnerDAO.existsById(businessOwnerId);
  }

  private boolean isNotExistsBusiness(long id) {
    return !businessDAO.existsById(id);
  }

  @Override
  public long deleteById(long id) {
    if (isNotExistsBusiness(id))
      throw new NotFoundBusinessException("کسب و کاری با شناسه %d یافت نشد".formatted(id));
    return businessDAO.deleteById(id);
  }

  @Override
  public Business getById(long id) {
    return businessDAO
        .selectBusinessByID(id)
        .orElseThrow(
            () -> new NotFoundBusinessException("کسب و کاری با شناسه %d یافت نشد".formatted(id)));
  }

  @Override
  public Business create(Business business) {
    if (isNotExistsBusinessOwner(business.businessOwnerId()))
      throw new NotFoundBusinessOwnerException(
          "صاحب کسب کاری با شناسه %d یافت نشد".formatted(business.businessOwnerId()));
    return businessDAO.insertBusiness(business);
  }
}
