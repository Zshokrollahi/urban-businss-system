package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.user.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private final JdbcClient jdbcClient;

    public BusinessService( JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    User test(
    ) {
        return jdbcClient.sql("select * from users where user_name = :id").param("id", 1L).query(User.class).single();
    }
}