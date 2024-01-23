package com.zingleside.urbanbusinesssystem.user.api;

import com.zingleside.urbanbusinesssystem.user.dao.UserJDBCDataAcessDAO;
import com.zingleside.urbanbusinesssystem.user.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "user manager")
public class UserController {
    private final UserJDBCDataAcessDAO userJDBCDataAcessService;

    public UserController(UserJDBCDataAcessDAO userJDBCDataAcessService) {
        this.userJDBCDataAcessService = userJDBCDataAcessService;
    }

    @GetMapping("/user")
    List<User> getAllUsers(){
        return userJDBCDataAcessService.selectAllusers();
    }



}
