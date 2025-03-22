package com.example.OneToMany.repositories;

import com.example.OneToMany.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

    @Query("SELECT u FROM UserDetails u LEFT JOIN FETCH u.orders WHERE u.userId = :id")
    Optional<UserDetails> findByIdWithOrders(Long id);
}
