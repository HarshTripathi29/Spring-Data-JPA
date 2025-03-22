package com.example.OneToOne.services;

import com.example.OneToOne.models.UserDetails;
import com.example.OneToOne.repositories.UserDetailsRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public String saveUser(UserDetails user){
    userDetailsRepository.save(user);
    return "saved";
    }

    public List<UserDetails> getAllUsers(){
        return userDetailsRepository.findAll();
    }
}
