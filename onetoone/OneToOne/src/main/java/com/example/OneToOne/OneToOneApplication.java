package com.example.OneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
		System.out.println("running on 8096");
	}

	// one user can have one address
	// using user address and user details association for one to one.

	//Infinite recursion occurs in a bidirectional One-to-One relationship because both entities hold references to each other.
	// When a framework (like Jackson) tries to serialize one entity into JSON, it follows the reference to the other entity,
	// which again references back to the first entity.
	// This cycle keeps repeating indefinitely, causing a StackOverflowError.
}
