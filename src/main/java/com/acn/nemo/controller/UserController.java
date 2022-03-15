package com.acn.nemo.controller;

import com.acn.nemo.dto.UserDtoOutput;
import com.acn.nemo.entity.User;
import com.acn.nemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        log.info("Inside createUser of UserController");
        return userService.createUser(user);
    }


    @GetMapping("/getUser/{id}")
    public UserDtoOutput getUser(@PathVariable("id") Long userId){
        log.info("Inside createUser of UserController");
        return userService.retriveUser(userId);
    }
}
