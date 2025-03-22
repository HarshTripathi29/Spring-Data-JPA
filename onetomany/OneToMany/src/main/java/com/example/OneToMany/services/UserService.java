package com.example.OneToMany.services;

import com.example.OneToMany.models.OrderDetails;
import com.example.OneToMany.models.UserDetails;
import com.example.OneToMany.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails saveUser(UserDetails userDetails) {
        if (userDetails.getOrders() != null) {
            for (OrderDetails order : userDetails.getOrders()) {
                order.setUserDetails(userDetails);
                System.out.println("Order linked: " + order.getProductName() + " -> " + order.getUserDetails().getName());
            }
        }
        return userRepository.save(userDetails);
    }


    @Transactional  // Ensures Lazy Fetching works within session
    public UserDetails getUserById(Long id){
        return userRepository.findById(id).get();
    }

}
