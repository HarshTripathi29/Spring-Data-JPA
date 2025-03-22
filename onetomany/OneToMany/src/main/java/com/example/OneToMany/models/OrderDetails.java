package com.example.OneToMany.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetails {

    // We store the foreign key (user_id_fk) in the order_details table
    // because it represents the "Many" side in a One-to-Many relationship.

    // - In a One-to-Many relationship, multiple `order_details` rows can be linked to a single `user_details_m` row.
    //- Storing the `user_id_fk` in `order_details` helps **identify which user placed the order**.

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;

    @ManyToOne
    @JoinColumn(name="user_id_owning_fk" , referencedColumnName = "userId")
    @JsonBackReference  // Prevents infinite recursion in JSON serialization
    private UserDetails userDetails;
    // join column is put in the owning side that has the foreign key the child table order details

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
