package com.zingleside.urbanbusinesssystem.advertising;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class AdvertisingJDBCDateAccess implements AdvertisingDAO {
    private final JdbcClient jdbcClient;

    public AdvertisingJDBCDateAccess(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public List<Advertising> selectALlAdvertising() {
        return jdbcClient.sql("select * from advertising").query(Advertising.class).list();
    }

    @Override
    public Optional<Advertising> selectAdvertisingByID(Long id) {
        return jdbcClient.sql("select * from advertising where id = :id").param("id",id).query(Advertising.class).stream().findFirst();
    }

    @Override
    public Advertising insertAdvertising(Advertising advertising) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into advertising(title,description,price) values (:title ,:description ,:price)")
                .paramSource(advertising).update(keyHolder);
        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id,title,description,price from advertising where id = :id")
                .param("id", id)
                .query(Advertising.class).single();

    }
}
