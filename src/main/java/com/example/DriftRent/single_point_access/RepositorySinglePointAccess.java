package com.example.DriftRent.single_point_access;

import com.example.DriftRent.repository.UserRepository;
import com.example.DriftRent.repository.implementation.UserRepositoryImpl;
import org.hibernate.SessionFactory;

public class RepositorySinglePointAccess {
    private SessionFactory sessionFactory;
    private static UserRepository userRepository;

    static{
        userRepository = new UserRepositoryImpl();
    }

    public static UserRepository getUserRepository(){
        return userRepository;
    }
}
