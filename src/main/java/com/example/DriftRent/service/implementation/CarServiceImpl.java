package com.example.DriftRent.service.implementation;

import com.example.DriftRent.model.Car;
import com.example.DriftRent.repository.CarRepository;
import com.example.DriftRent.service.CarService;
import com.example.DriftRent.single_point_access.RepositorySinglePointAccess;

import java.util.List;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository = RepositorySinglePointAccess.getCarRepository();

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public boolean delete(Car car) {
        return carRepository.delete(car);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findall();
    }

}