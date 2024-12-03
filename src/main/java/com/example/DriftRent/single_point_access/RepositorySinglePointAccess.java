package com.example.DriftRent.single_point_access;

import com.example.DriftRent.repository.AdRepository;
import com.example.DriftRent.repository.CarRepository;
import com.example.DriftRent.repository.UserRepository;
import com.example.DriftRent.repository.implementation.AdRepositoryImpl;
import com.example.DriftRent.repository.implementation.CarRepositoryImpl;
import com.example.DriftRent.repository.implementation.UserRepositoryImpl;

public class RepositorySinglePointAccess {
    private static UserRepository userRepository;
    private static CarRepository carRepository;
    private static AdRepository adRepository;

    static {
        userRepository = new UserRepositoryImpl();
        carRepository = new CarRepositoryImpl();
        adRepository = new AdRepositoryImpl();
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static CarRepository getCarRepository() {
        return carRepository;
    }

    public static AdRepository getAdRepository() {return adRepository;}
}