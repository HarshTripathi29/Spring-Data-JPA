package com.example.OneToMany.controllers;

import com.example.OneToMany.dtos.UserDetailsDto;
import com.example.OneToMany.models.UserDetails;
import com.example.OneToMany.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user-details")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDetails saveUser(@RequestBody UserDetails userDetails){
    return userService.saveUser(userDetails);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetailsDto getUserById(@PathVariable Long id){
        UserDetails output = userService.getUserById(id);
        System.out.println("going to map user details to user dto");
        UserDetailsDto userDto = output.mapUserDetailsToDTO();
        return userDto;
    }

}
