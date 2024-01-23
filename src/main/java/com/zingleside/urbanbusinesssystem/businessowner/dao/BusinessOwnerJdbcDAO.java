package com.zingleside.urbanbusinesssystem.businessowner.dao;

import com.zingleside.urbanbusinesssystem.businessowner.model.BusinessOwner;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BusinessOwnerJdbcDAO implements BusinessOwnerDAO {

  private final JdbcClient jdbcClient;

  public BusinessOwnerJdbcDAO(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public boolean existsByNationalCode(String nationalCode) {
    return jdbcClient
        .sql("select count(id)>0 from business_owners where national_code = :nationalCode")
        .param("nationalCode", nationalCode)
        .query(Boolean.class)
        .single();
  }

  @Override
  public BusinessOwner insertNewOwner(BusinessOwner businessOwner) {

    jdbcClient
        .sql(
            "insert into business_owners(name, last_name, national_code, phone_number) values (:name ,:lastName,:nationalCode ,:phoneNumber)")
        .paramSource(businessOwner)
        .update();

    return jdbcClient
        .sql("select * from business_owners order by id desc limit 1")
        .query(BusinessOwner.class)
        .single();
  }

  @Override
  public BusinessOwner updateById(BusinessOwner businessOwner) {
    jdbcClient
        .sql(
            "update business_owners set name = :name, last_name = :lastName , national_code= :nationalCode, phone_number = :phoneNumber where id = :id")
        .paramSource(businessOwner)
        .update();

    return jdbcClient
        .sql("select * from business_owners where id = :id")
        .param("id", businessOwner.id())
        .query(BusinessOwner.class)
        .single();
  }

  @Override
  public boolean existsById(long id) {
    return jdbcClient
        .sql("select count(id)>0 from business_owners where id = :id")
        .param("id", id)
        .query(Boolean.class)
        .single();
  }

  @Override
  public long deleteById(long id) {
    return jdbcClient.sql("delete from business_owners where id = :id").param("id", id).update();
  }

  @Override
  public List<BusinessOwner> getAll() {
    return jdbcClient.sql("select * from business_owners").query(BusinessOwner.class).list();
  }

  @Override
  public Optional<BusinessOwner> getById(long id) {
    return jdbcClient
        .sql("select * from business_owners where id = :id")
        .param("id", id)
        .query(BusinessOwner.class)
        .optional();
  }
}
