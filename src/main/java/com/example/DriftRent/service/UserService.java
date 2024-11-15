package com.example.DriftRent.service;

import com.example.DriftRent.model.User;

public interface UserService {
    User save(User user);
    User update(User user);
    User findUserByEmail(String email);
    boolean delete(User user);
    User login(String email, String password);
}
