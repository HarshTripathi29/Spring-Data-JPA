package com.example.OneToOne.services;

import com.example.OneToOne.models.UserAddress;
import com.example.OneToOne.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public Optional<UserAddress> getUserAddress(@PathVariable Long id){
        return userAddressRepository.findById(id);
    }

}
