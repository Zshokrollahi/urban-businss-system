package com.zingleside.urbanbusinesssystem.business.dao;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BusinessJDBCDataAccessService implements BusinessDAO {
  private final JdbcClient jdbcClient;

  public BusinessJDBCDataAccessService(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public List<Business> selectAllBusinesses() {
    return jdbcClient.sql("select * from businesses").query(Business.class).list();
  }

  @Override
  public Optional<Business> selectBusinessByID(Long id) {
    return jdbcClient
        .sql("select * from businesses where id = :id")
        .param("id", id)
        .query(Business.class)
        .optional();
  }

  @Override
  public Business insertBusiness(Business business) {
    jdbcClient
        .sql(
            "insert into businesses(name,phone_number,description,address,business_owner_id) values (:name ,:phoneNumber,:description ,:address,:businessOwnerId)")
        .paramSource(business)
        .update();

    return jdbcClient
        .sql("select * from businesses order by id desc limit 1")
        .query(Business.class)
        .single();
  }

  @Override
  public boolean existsById(long id) {
    return jdbcClient
        .sql("select count(id)>0 from businesses where id = :id")
        .param("id", id)
        .query(boolean.class)
        .single();
  }

  @Override
  public Business updateById(Business business) {
    jdbcClient
        .sql(
            "update businesses set name = :name, phone_number = :phoneNumber ,description = :description, address = :address , business_owner_id= :businessOwnerId where id = :id")
        .paramSource(business)
        .update();

    return jdbcClient
        .sql("select * from businesses where id = :id")
        .param("id", business.id())
        .query(Business.class)
        .single();
  }

  @Override
  public long deleteById(long id) {
    return jdbcClient.sql("delete from businesses where id = :id").param("id", id).update();
  }
}
