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
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the DriftRent Spring Boot application.
 */
@SpringBootApplication
public class DriftRentApplication {

	/**
	 * Service for managing users.
	 */
	@Autowired
	private UserService userService; // Autowiring UserService

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DriftRentApplication.class, args);
	}
}