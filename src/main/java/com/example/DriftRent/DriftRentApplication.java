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
//		User user = userRepository.findUserByEmail("daniel");
//		System.out.println(user);
//		User user = new User();
//		user.setEmail("daniel");
//		user.setPassword("1234");
//		user.setRating(4.5);
//		userRepository.save(user);
		User user2 = userRepository.findUserByEmail("daniel");
		System.out.println(user2);
	}
}
