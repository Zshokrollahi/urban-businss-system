package com.zingleside.urbanbusinesssystem.businessOwner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessOwnerService {

    private final BusinessOwnerRepo businessOwnerRepo;

    public BusinessOwnerService(@Qualifier("fake") BusinessOwnerRepo businessOwnerRepo) {
        this.businessOwnerRepo = businessOwnerRepo;
    }

    List<BusinessOwner> getbusinessOwner(){
        return businessOwnerRepo.getOwner();
    }

}
