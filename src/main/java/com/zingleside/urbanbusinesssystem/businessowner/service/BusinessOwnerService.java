package com.zingleside.urbanbusinesssystem.businessowner.service;

import com.zingleside.urbanbusinesssystem.businessowner.dao.BusinessOwnerDAO;
import com.zingleside.urbanbusinesssystem.businessowner.exception.BusinessOwnerNationalCodeConflictException;
import com.zingleside.urbanbusinesssystem.businessowner.exception.NotFoundBusinessOwnerException;
import com.zingleside.urbanbusinesssystem.businessowner.model.BusinessOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessOwnerService implements BusinessOwnerServiceContract {
  private final BusinessOwnerDAO businessOwnerDAO;

  @Autowired
  public BusinessOwnerService(BusinessOwnerDAO businessOwnerDAO) {
    this.businessOwnerDAO = businessOwnerDAO;
  }

  @Override
  public BusinessOwner create(BusinessOwner businessOwner) {
    if (businessOwnerDAO.existsByNationalCode(businessOwner.nationalCode()))
      throw new BusinessOwnerNationalCodeConflictException();
    return businessOwnerDAO.insertNewOwner(businessOwner);
  }

  @Override
  public BusinessOwner update(BusinessOwner businessOwner) {
    if (!businessOwnerDAO.existsById(businessOwner.id()))
      throw new NotFoundBusinessOwnerException(
          "صاحب کسب کاری با شناسه %d یافت نشد".formatted(businessOwner.id()));
    return businessOwnerDAO.updateById(businessOwner);
  }

  @Override
  public long deleteById(long id) {
    if (!businessOwnerDAO.existsById(id))
      throw new NotFoundBusinessOwnerException("صاحب کسب کاری با شناسه %d یافت نشد".formatted(id));
    return businessOwnerDAO.deleteById(id);
  }

  @Override
  public List<BusinessOwner> findAll() {
    return businessOwnerDAO.getAll();
  }

  @Override
  public BusinessOwner getById(long id) {
    return businessOwnerDAO
        .getById(id)
        .orElseThrow(
            () ->
                new NotFoundBusinessOwnerException(
                    "صاحب کسب کاری با شناسه %d یافت نشد".formatted(id)));
  }
}
