package com.zingleside.urbanbusinesssystem.user;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> selectAllusers();
    Optional<User> selectUserByID();
    void insertUser(User user);
    boolean existsUserWithID(Integer id);
    void deleteUserWithID(Integer userId);
    void updateUser(User update);
}
