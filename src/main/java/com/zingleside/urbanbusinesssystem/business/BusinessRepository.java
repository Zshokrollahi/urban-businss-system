package com.zingleside.urbanbusinesssystem.business;


import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
