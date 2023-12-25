package com.zingleside.urbanbusinesssystem.user;

import com.zingleside.urbanbusinesssystem.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserJDBCDataAcessService implements UserDAO {
    @Override
    public List<User> selectAllusers() {
        return null;
    }

    @Override
    public Optional<User> selectUserByID() {
        return Optional.empty();
    }

    @Override
    public void insertUser(User user) {

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
