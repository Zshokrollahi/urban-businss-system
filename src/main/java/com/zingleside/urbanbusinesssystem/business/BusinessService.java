package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.user.entity.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {
    private final BusinessDAO businessDAO;
    private final JdbcClient jdbcClient;

    public BusinessService(BusinessDAO businessDAO, JdbcClient jdbcClient) {
        this.businessDAO = businessDAO;
        this.jdbcClient = jdbcClient;
    }

    User test(
    ) {
        return null;
    }
}