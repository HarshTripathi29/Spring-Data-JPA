package com.example.OneToOne.controllers;

import com.example.OneToOne.dtos.UserDetailsDTO;
import com.example.OneToOne.models.UserDetails;
import com.example.OneToOne.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-details")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public String saveUser(@RequestBody UserDetails user){
        return userDetailsService.saveUser(user);
    }

    @GetMapping
    public List<UserDetailsDTO> getAllUsers(){
        return userDetailsService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id){
        return userDetailsService.getUserById(id);
    }
}
