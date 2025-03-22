package com.example.OneToMany.services;

import com.example.OneToMany.models.UserDetails;
import com.example.OneToMany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails saveUser(UserDetails userDetails){
    return userRepository.save(userDetails);
    }

}
