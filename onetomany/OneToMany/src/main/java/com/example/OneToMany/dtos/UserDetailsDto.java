package com.example.OneToMany.dtos;

import com.example.OneToMany.models.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsDto {
    private Long id;
    private String name;
    private String age;
    private String phoneNo;
    private List<OrderDetailsDto> orders;  // Use DTO instead of Entity

    public UserDetailsDto(UserDetails userDetails) {
        this.id = userDetails.getUserId();
        this.name = userDetails.getName();
        this.age = userDetails.getAge();
        this.phoneNo = userDetails.getPhoneNo();

        System.out.println("now the orders ");

        // Convert OrderDetails to OrderDetailsDto
        if (userDetails.getOrders() != null) {
            this.orders = userDetails.getOrders().stream()
                    .map(OrderDetailsDto::new)
                    .collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<OrderDetailsDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetailsDto> orders) {
        this.orders = orders;
    }
}
