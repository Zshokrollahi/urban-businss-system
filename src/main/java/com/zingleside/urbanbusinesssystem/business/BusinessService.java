package com.zingleside.urbanbusinesssystem.business;

import org.springframework.beans.factory.annotation.Qualifier;

public class BusinessService {

    private final BusinessDAO businessDAO;

    public BusinessService(@Qualifier("jpa") BusinessDAO businessDAO) {
        this.businessDAO = businessDAO;
    }
}