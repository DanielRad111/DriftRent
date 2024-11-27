package com.example.DriftRent.service.implementation;

import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.UserRepository;
import com.example.DriftRent.service.UserService;
import com.example.DriftRent.single_point_access.RepositorySinglePointAccess;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository = RepositorySinglePointAccess.getUserRepository();

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public User login(String email, String password) {
        // Find the user by email
        User user = userRepository.findUserByEmail(email);

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