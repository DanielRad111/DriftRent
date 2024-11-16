package com.example.DriftRent.single_point_access;

import com.example.DriftRent.service.UserService;
import com.example.DriftRent.service.implementation.UserServiceImpl;

public class ServiceSinglePointAccess {
    private static UserService userService;
    static{
        userService = new UserServiceImpl();
    }
    public static UserService getUserService(){
        return userService;
    }
}
