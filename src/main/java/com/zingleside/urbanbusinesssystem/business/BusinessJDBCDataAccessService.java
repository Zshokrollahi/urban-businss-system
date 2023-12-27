package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BusinessJDBCDataAccessService implements BusinessDAO{
    private final JdbcTemplate jdbcTemplate;
    private final BusinessRowMapper businessRowMapper;
    private final JdbcClient jdbcClient;

    public BusinessJDBCDataAccessService(JdbcTemplate jdbcTemplate, BusinessRowMapper businessRowMapper, JdbcClient jdbcClient) {
        this.jdbcTemplate = jdbcTemplate;
        this.businessRowMapper = businessRowMapper;
        this.jdbcClient = jdbcClient;
    }

   /* @Override
    public List<Business> selectAllBusinesses() {
       return jdbcClient.sql("select * from business").query(new BusinessRowMapper()).list();

    }*/

    @Override
    public List<Business> selectAllBusinesses() {
        return null;
    }

    @Override
    public Optional<Business> selectBusinessByID() {
       var sql = """
               select id,name,description,phone_number,address
                       from business
                       where id = ?
               """ ;
       return jdbcTemplate.query(sql,businessRowMapper)
               .stream()
               .findFirst();
    }

    @Override
    public void insertBusiness(Business business) {

    }

  /*  @Override
    public void insertBusiness(Business business) {

      return null;
    }*/

    @Override
    public boolean existBusinessWithID(Integer id) {
        return false;
    }

    @Override
    public void deleteBusinessWithID(Integer businessId) {

    }

    @Override
    public void BusinessUpdate(Business update) {
        if (update.getName() != null){
            String sql = """
                    update business  set name = ? where id =?
                    """;
            int result = jdbcTemplate.update(sql,update.getName(),update.getId());
            System.out.println("update business name" + result);
        }


    }
}
