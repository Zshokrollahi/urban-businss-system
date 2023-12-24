package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jdbc")
public class BusinessJDBCDataAccessService implements BusinessDAO{
    private final JdbcTemplate jdbcTemplate;
    private final BusinessRowMapper businessRowMapper;

    public BusinessJDBCDataAccessService(JdbcTemplate jdbcTemplate, BusinessRowMapper businessRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.businessRowMapper = businessRowMapper;
    }

    @Override
    public List<Business> selectAllBusinesses() {
        var sql = """
                select id,name,description,phone_number,address
                from business
                """;
        return jdbcTemplate.query(sql,businessRowMapper);

    }

    @Override
    public Optional<Business> selectBusinessByID() {
       var sql = """
               select id,name,description,phone_number,address
                       from business
                       where id = ?
               """ ;
       return jdbcTemplate.query((sql,businessRowMapper)
               .stream()
               .findFirst();
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
        if (update.getName() != null){
            String sql = """
                    update business  set name = ? where id =?
                    """;
            int result = jdbcTemplate.update(sql,update.getName(),update.getId());
            System.out.println("update business name" + result);
        }


    }
}
