package com.zingleside.urbanbusinesssystem;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@EnableJpaRepositories
@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class UrbanBusinessSystemApplication {

    private final JdbcClient jdbcClient;

    public static void main(String[] args) {
        SpringApplication.run(UrbanBusinessSystemApplication.class, args);
    }
/*
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            var keyHolder = new GeneratedKeyHolder();
            var bussines = jdbcClient.sql("insert into business(name, description, phone_number, address) values (:name,:description,:phone_number,:address)")
                    .params(Map.of(
                            "name", "shop",
                            "description", "shop is present",
                            "phone_number", "09131911893",
                            "address", "kerman rafsanjan"
                    ))
                    .update(keyHolder);
            log.info("bussines %d".formatted(Objects.requireNonNull(keyHolder.getKey()).longValue()));
        };
    }*/
}
