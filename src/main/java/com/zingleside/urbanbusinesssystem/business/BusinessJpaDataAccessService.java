package com.zingleside.urbanbusinesssystem.business;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class BusinessJpaDataAccessService implements BusinessDAO {

    private final BusinessRepository businessRepository;

    public BusinessJpaDataAccessService(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Business> selectAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Optional<Business> selectBusinessByID() {
        return Optional.empty();
    }
}
