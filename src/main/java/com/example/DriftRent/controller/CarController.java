package com.example.DriftRent.controller;

import com.example.DriftRent.dto.CarDTO;
import com.example.DriftRent.model.Car;
import com.example.DriftRent.service.CarService;
import com.example.DriftRent.single_point_access.ServiceSinglePointAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing cars.
 */
@RestController
@RequestMapping("/car")
public class CarController {
    private CarService carService = ServiceSinglePointAccess.getCarService();

    /**
     * Converts a Car entity to a CarDTO.
     *
     * @param car the Car entity to convert
     * @return the converted CarDTO
     */
    private CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
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

    /**
     * Creates a new car.
     *
     * @param car the Car entity to create
     * @return the created CarDTO
     */
    @PostMapping("/create")
    public ResponseEntity<CarDTO> createCar(@RequestBody Car car) {
        Car savedCar = carService.save(car);
        CarDTO carDTO = convertToDTO(savedCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }

    /**
     * Deletes a car.
     *
     * @param carDTO the CarDTO of the car to delete
     * @return a ResponseEntity indicating the result of the operation
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCar(@RequestBody CarDTO carDTO) {
        if (carDTO.getVIN() == null || carDTO.getVIN().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Car car = carService.findCarById(carDTO.getId());
        boolean deleted = carService.delete(car);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Updates an existing car.
     *
     * @param car the Car entity with updated information
     * @return the updated CarDTO
     */
    @PutMapping("/update")
    public ResponseEntity<CarDTO> update(@RequestBody Car car) {
        Car carFromDB = carService.findCarById(car.getId());
        carFromDB.setVIN(car.getVIN());
        carFromDB.setBrand(car.getBrand());
        carFromDB.setModel(car.getModel());
        carFromDB.setBody(car.getBody());
        carFromDB.setYearOfManufacture(car.getYearOfManufacture());
        carFromDB.setKm(car.getKm());
        carFromDB.setFuelType(car.getFuelType());
        carFromDB.setGearBox(car.getGearBox());
        carFromDB.setCylindricalCapacity(car.getCylindricalCapacity());
        carFromDB.setHorsePower(car.getHorsePower());
        carFromDB.setColor(car.getColor());
        Car carUpdated = carService.update(carFromDB);
        CarDTO carDTO = convertToDTO(carUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(carDTO);
    }
}