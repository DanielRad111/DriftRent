package com.example.DriftRent;

import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.implementation.UserRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DriftRentApplication {
	public static void main(String[] args) {
		SpringApplication.run(DriftRentApplication.class, args);
		UserRepositoryImpl userRepository = new UserRepositoryImpl();

		User retrievedUser = userRepository.findUserByEmail("daniel@example.com");
		System.out.println(retrievedUser);
	}
}
