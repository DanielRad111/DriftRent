package com.example.DriftRent.service;

import com.example.DriftRent.model.Car;

import java.util.List;

public interface CarService {
    Car findCarById(Integer id);

    Car save(Car car);

    Car update(Car car);

    boolean delete(Car car);

    List<Car> findAllCars();
}