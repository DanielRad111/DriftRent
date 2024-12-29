package com.example.DriftRent.service;

import com.example.DriftRent.dto.CarDTO;
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

    public CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setVIN(car.getVIN());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setBody(car.getBody());
        carDTO.setYearOfManufacture(car.getYearOfManufacture());
        carDTO.setKm(car.getKm());
        carDTO.setFuelType(car.getFuelType());
        carDTO.setGearBox(car.getGearBox());
        carDTO.setCylindricalCapacity(car.getCylindricalCapacity());
        carDTO.setHorsePower(car.getHorsePower());
        carDTO.setColor(car.getColor());
        return carDTO;
    }

}