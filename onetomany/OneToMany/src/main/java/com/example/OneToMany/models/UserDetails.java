package com.example.OneToMany.models;

import com.example.OneToMany.dtos.UserDetailsDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_details_m")
public class UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String age;
    private String phoneNo;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference  // Prevents infinite recursion in JSON serialization
    // @JoinColumn(name="user_id_fk", referencedColumnName = "userId")
    // here join column is used to tell jpa not to create a new table rather store the fk in the child table
    private List<OrderDetails> orders = new ArrayList<>();

    public UserDetailsDto mapUserDetailsToDTO(){
        return new UserDetailsDto(this);
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }


    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
        for(OrderDetails order : orders){
            order.setUserDetails(this);
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


}
