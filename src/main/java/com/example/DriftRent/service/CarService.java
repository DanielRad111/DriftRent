package com.example.DriftRent.service;

import com.example.DriftRent.model.Car;
import com.example.DriftRent.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car findCarById(Integer id) {
        return carRepository.findById(id).get();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car update(Car car) {
        return carRepository.save(car);
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

}