package com.example.OneToMany.dtos;

import com.example.OneToMany.models.OrderDetails;
import com.example.OneToMany.models.UserDetails;

import java.util.List;

public class UserDetailsDto {
    private Long id;
    private String name;
    private String age;
    private String phoneNo;
    private List<OrderDetails> orders;

    public UserDetailsDto(UserDetails userDetails) {
        this.id = userDetails.getUserId();
        this.name = userDetails.getName();
        this.age = userDetails.getAge();
        this.phoneNo = userDetails.getPhoneNo();

        System.out.println("now the orders ");
        this.orders = userDetails.getOrders();
    }
}
