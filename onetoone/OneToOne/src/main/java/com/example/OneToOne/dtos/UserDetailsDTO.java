package com.example.OneToOne.dtos;


import com.example.OneToOne.models.UserAddress;
import com.example.OneToOne.models.UserDetails;

public class UserDetailsDTO {

    private Long id;
    private String name;
    private String phoneNo;
    private String age;

    private String address;

    // constructor to populate from the user details entity;
    public UserDetailsDTO(UserDetails userDetails){
        this.id=userDetails.getId();
        this.name=userDetails.getName();
        this.phoneNo=userDetails.getPhoneNo();
        this.age=userDetails.getAge();

        System.out.println("now user address");
        this.address=userDetails.getAddress()!=null ?
                userDetails.getAddress().getStreet():null;
    }

    public UserDetailsDTO(Long id, String name, String phoneNo, String age, UserAddress address) {
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
