package com.zingleside.urbanbusinesssystem.user.dao;

import com.zingleside.urbanbusinesssystem.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> selectAllusers();
    Optional<User> selectUserByID();
    User insertNewUser(User user);
    boolean existsUserWithID(Integer id);
    void deleteUserWithID(Integer userId);
    void updateUser(User update);
}
