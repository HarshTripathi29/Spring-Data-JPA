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
}
