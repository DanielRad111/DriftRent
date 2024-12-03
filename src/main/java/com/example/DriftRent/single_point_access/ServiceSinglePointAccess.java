package com.example.DriftRent.single_point_access;

import com.example.DriftRent.service.AdService;
import com.example.DriftRent.service.CarService;
import com.example.DriftRent.service.UserService;
import com.example.DriftRent.service.implementation.AdServiceImpl;
import com.example.DriftRent.service.implementation.CarServiceImpl;
import com.example.DriftRent.service.implementation.UserServiceImpl;

public class ServiceSinglePointAccess {
    private static UserService userService;
    private static CarService carService;
    private static AdService adService;

    static {
        userService = new UserServiceImpl();
        carService = new CarServiceImpl();
        adService = new AdServiceImpl();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static CarService getCarService() {
        return carService;
    }

    public static AdService getAdService(){return adService;}
}