package com.example.DriftRent.service;

import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User findUserById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User update(User user) {
        return this.userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public void delete(User user) {
         this.userRepository.delete(user);
    }

    public User login(String email, String password) {
        // Find the user by email
        User user = this.userRepository.findUserByEmail(email);

        // If user doesn't exist, return null
        if (user == null) {
            return null;
        }

        // Check if the provided password matches the stored password
        if (user.getPassword().equals(password)) {
            return user;
        }

        // If password doesn't match, return null
        return null;
    }
}