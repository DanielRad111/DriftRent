package com.example.DriftRent;

import com.example.DriftRent.dto.LoginRequestDTO;
import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.implementation.UserRepositoryImpl;
import com.example.DriftRent.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DriftRentApplication {

	@Autowired
	private UserService userService; // Autowiring UserService

	public static void main(String[] args) {
		SpringApplication.run(DriftRentApplication.class, args);
	}

	// After the application context is up, let's test the login method
	@PostConstruct
	public void testLogin() {
		// Prepare a LoginRequestDTO object
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		loginRequestDTO.setEmail("daniel@example.com");
		loginRequestDTO.setPassword("password123");

		// Call the login method using LoginRequestDTO
		User user = userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

		if (user != null) {
			System.out.println("Login successful: " + user);
		} else {
			System.out.println("Login failed: Invalid email or password");
		}
	}
}
