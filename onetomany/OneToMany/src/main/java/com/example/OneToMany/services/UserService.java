package com.example.OneToMany.services;

import com.example.OneToMany.models.UserDetails;
import com.example.OneToMany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails saveUser(UserDetails userDetails){
    return userRepository.save(userDetails);
    }

    public UserDetails getUserById(Long id){
        return userRepository.findById(id).get();
    }

}
