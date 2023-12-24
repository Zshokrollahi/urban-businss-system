package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jdbc")
public class BusinessJDBCDataAccessService implements BusinessDAO{
    private final JdbcTemplate jdbcTemplate;

    public BusinessJDBCDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Business> selectAllBusinesses() {
        return null;
    }

    @Override
    public Optional<Business> selectBusinessByID() {
        return Optional.empty();
    }

    @Override
    public void insertBusiness(Business business) {
        var sql = """
                insert into business (id,name,description,phone_number,address)
                values (? ,? ,? , ? , ? ,?)
                  """;
        int update =jdbcTemplate.update(sql,
                business.getId(),
                business.getName(),
                business.getDescription(),
                business.getAddress(),
                business.getPhoneNumber()
        );
        System.out.println(update);

    }

    @Override
    public boolean existBusinessWithID(Integer id) {
        return false;
    }

    @Override
    public void deleteBusinessWithID(Integer businessId) {

    }

    @Override
    public void BusinessUpdate(Business update) {

    }
}
