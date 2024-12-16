package com.example.DriftRent.repository;

import com.example.DriftRent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserByRating(Double rating);
}