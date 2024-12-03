package com.example.DriftRent.repository;

import com.example.DriftRent.model.Car;

import java.util.List;

public interface CarRepository extends CRUDRepository<Car, Integer> {
    List<Car> findall();
}