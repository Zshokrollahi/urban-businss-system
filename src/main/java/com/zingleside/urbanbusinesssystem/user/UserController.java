package com.zingleside.urbanbusinesssystem.user;

import com.zingleside.urbanbusinesssystem.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping ("/user")
    void  createNewUser(@RequestBody User user ){
        System.out.println("new user request");
        System.out.println(user);
    }

    @GetMapping("/user")
    void  getAllUsers(@RequestBody User user){
        System.out.println(user);

    }


}
