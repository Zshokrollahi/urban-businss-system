package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class BusinessRowMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Business business = new Business(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("phoneNumber"),
                resultSet.getString("addrerss")
        );
        return null;

    }
}
