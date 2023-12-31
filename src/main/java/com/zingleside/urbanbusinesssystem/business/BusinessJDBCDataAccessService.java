package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;
import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BusinessJDBCDataAccessService implements BusinessDAO{
    private final BusinessRowMapper businessRowMapper;
    private final JdbcClient jdbcClient;

    public BusinessJDBCDataAccessService(BusinessRowMapper businessRowMapper, JdbcClient jdbcClient) {
        this.businessRowMapper = businessRowMapper;
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Business> selectAllBusinesses() {
        return jdbcClient.sql("select * from business").query(new BusinessRowMapper()).list();
    }

    @Override
    public Optional<Business>  selectBusinessByID( Long id) {
      return jdbcClient.sql("select * from business where id = :id").query(businessRowMapper).stream().findFirst();
    }

    @Override
    public Business insertBusiness(Business business) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into business(name,phone_number,description,address) values (:name ,:phoneNumber,:description ,:address)")
                .paramSource(business).update(keyHolder);
        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id,name,phone_number,description,address from business where id = :id")
                .param("id", id)
                .query(Business.class).single();

    }

    }

