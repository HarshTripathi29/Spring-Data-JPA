package com.example.OneToMany.dtos;

import com.example.OneToMany.models.OrderDetails;

public class OrderDetailsDto {
    private Long id;
    private String productName;

    public OrderDetailsDto(OrderDetails order) {
        this.id = order.getId();
        this.productName = order.getProductName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
