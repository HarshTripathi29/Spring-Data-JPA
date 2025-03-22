package com.example.OneToMany.controllers;

import com.example.OneToMany.models.UserDetails;
import com.example.OneToMany.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-details")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDetails saveUser(@RequestBody UserDetails userDetails){
    return userService.saveUser(userDetails);
    }
}
