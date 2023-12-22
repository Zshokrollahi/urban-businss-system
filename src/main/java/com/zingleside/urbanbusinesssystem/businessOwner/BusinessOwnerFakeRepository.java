package com.zingleside.urbanbusinesssystem.businessOwner;

import com.zingleside.urbanbusinesssystem.businessOwner.entity.BusinessOwner;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository(value = "fake")
public class BusinessOwnerFakeRepository implements BusinessOwnerRepo{
    @Override
    public List<BusinessOwner> getOwner() {
        return Arrays.asList( new BusinessOwner(1,"ali","tabi" ,"304004004",0432433323));
    }
    }

