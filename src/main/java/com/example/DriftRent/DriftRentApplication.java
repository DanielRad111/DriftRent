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

@SpringBootApplication
public class DriftRentApplication {

	@Autowired
	private UserService userService; // Autowiring UserService

	public static void main(String[] args) {
		SpringApplication.run(DriftRentApplication.class, args);
	}

}