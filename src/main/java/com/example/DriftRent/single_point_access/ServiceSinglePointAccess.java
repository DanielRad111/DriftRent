package com.example.DriftRent.single_point_access;

import com.example.DriftRent.service.CarService;
import com.example.DriftRent.service.UserService;
import com.example.DriftRent.service.implementation.CarServiceImpl;
import com.example.DriftRent.service.implementation.UserServiceImpl;

public class ServiceSinglePointAccess {
    private static UserService userService;
    private static CarService carService;

    static {
        userService = new UserServiceImpl();
        carService = new CarServiceImpl();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static CarService getCarService() {
        return carService;
    }
}