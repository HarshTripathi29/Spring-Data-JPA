package com.example.OneToOne.controllers;

import com.example.OneToOne.models.UserAddress;
import com.example.OneToOne.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user-address")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("{id}")
    public Optional<UserAddress> getAddressById(@PathVariable Long id){
        return userAddressService.getUserAddress(id);
    }
}
