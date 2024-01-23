package com.zingleside.urbanbusinesssystem.user.dao;

import com.zingleside.urbanbusinesssystem.user.model.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserJDBCDataAcessDAO implements UserDAO {

    private final JdbcClient jdbcClient;

    public UserJDBCDataAcessDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<User> selectAllusers() {

        return jdbcClient.sql("select * from users").query(User.class).list();
    }

    @Override
    public Optional<User> selectUserByID() {
        return Optional.empty();
    }

    @Override
    public User insertNewUser(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into users(user_name, name, last_name, phone_number, password) values (:username, :name , :lastName :phoneNumber ,:password)")
                .paramSource(user).update(keyHolder);

        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id, user_name, name, last_name, phone_number, password  from users where id = :id")
                .param("id", id)
                .query(User.class).single();
    }

    @Override
    public boolean existsUserWithID(Integer id) {
        return false;
    }

    @Override
    public void deleteUserWithID(Integer userId) {

    }

    @Override
    public void updateUser(User update) {

    }
}

