package com.example.OneToOne.services;

import com.example.OneToOne.dtos.UserDetailsDTO;
import com.example.OneToOne.models.UserDetails;
import com.example.OneToOne.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public String saveUser(UserDetails user){
    userDetailsRepository.save(user);
    return "saved";
    }

    public List<UserDetailsDTO> getAllUsers(){
        List<UserDetails>users = userDetailsRepository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException("No users found in the database.");
        }
        users.forEach(user -> System.out.println(user.getId() + " - " + user.getName()));

        return users.stream()
                .map(user -> new UserDetailsDTO(
                        user.getId(),
                        user.getName(),
                        user.getPhoneNo(),
                        user.getAge(),
                        user.getAddress() != null ? user.getAddress() : null // Avoid LazyInitializationException
                ))
                .collect(Collectors.toList());
    }

    private UserDetailsDTO convertToDto(UserDetails userDetails){
        return new UserDetailsDTO(
                userDetails.getId(),
                userDetails.getName(),
                userDetails.getPhoneNo(),
                userDetails.getAge(),
                userDetails.getAddress()
        );
    }

    public UserDetailsDTO getUserById(Long id){
        return userDetailsRepository.findById(id).get().toDto();
    }
}
