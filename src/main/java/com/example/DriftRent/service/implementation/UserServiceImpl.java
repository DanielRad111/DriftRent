package com.example.DriftRent.service.implementation;

import com.example.DriftRent.model.User;
import com.example.DriftRent.repository.UserRepository;
import com.example.DriftRent.service.UserService;
import com.example.DriftRent.single_point_access.RepositorySinglePointAccess;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = RepositorySinglePointAccess.getUserRepository();

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
        return null;
    }
}
