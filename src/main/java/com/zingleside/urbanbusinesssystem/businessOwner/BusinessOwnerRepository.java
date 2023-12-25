package com.zingleside.urbanbusinesssystem.businessOwner;

import com.zingleside.urbanbusinesssystem.businessOwner.entity.BusinessOwner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@Primary
public class BusinessOwnerRepository {
    public List<BusinessOwner> getOwner() {
        //TODO connect to real db
        return Collections.emptyList();
    }
}
