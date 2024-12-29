package com.example.DriftRent.controller;

import com.example.DriftRent.dto.CarDTO;
import com.example.DriftRent.model.Car;
import com.example.DriftRent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @PostMapping("/create")
    public ResponseEntity<CarDTO> createCar(@RequestBody Car car) {

        Car savedCar = carService.save(car);
        CarDTO carDTO = carService.convertToDTO(savedCar);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCar(@RequestBody CarDTO carDTO) {
        if (carDTO.getVIN() == null || carDTO.getVIN().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Car car = carService.findCarById(carDTO.getId());
        carService.delete(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

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
        CarDTO carDTO = carService.convertToDTO(carUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(carDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDTO>> getAllCars(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String body,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear,
            @RequestParam(required = false) Integer minKm,
            @RequestParam(required = false) Integer maxKm,
            @RequestParam(required = false) String fuelType,
            @RequestParam(required = false) String gearBox,
            @RequestParam(required = false) Integer minEngineCapacity,
            @RequestParam(required = false) Integer maxEngineCapacity,
            @RequestParam(required = false) Integer minHorsePower,
            @RequestParam(required = false) Integer maxHorsePower,
            @RequestParam(required = false) String color) {

        List<Car> cars = carService.findAllCars();

        List<Car> filteredCars = cars.stream()
                .filter(car -> (brand == null || car.getBrand().equalsIgnoreCase(brand)))
                .filter(car -> (model == null || car.getModel().equalsIgnoreCase(model)))
                .filter(car -> (body == null || car.getBody().equalsIgnoreCase(body)))
                .filter(car -> (startYear == null || car.getYearOfManufacture() >= startYear))
                .filter(car -> (endYear == null || car.getYearOfManufacture() <= endYear))
                .filter(car -> (minKm == null || car.getKm() >= minKm))
                .filter(car -> (maxKm == null || car.getKm() <= maxKm))
                .filter(car -> (fuelType == null || car.getFuelType().equalsIgnoreCase(fuelType)))
                .filter(car -> (gearBox == null || car.getGearBox().equalsIgnoreCase(gearBox)))
                .filter(car -> (minEngineCapacity == null || car.getCylindricalCapacity() >= minEngineCapacity))
                .filter(car -> (maxEngineCapacity == null || car.getCylindricalCapacity() <= maxEngineCapacity))
                .filter(car -> (minHorsePower == null || car.getHorsePower() >= minHorsePower))
                .filter(car -> (maxHorsePower == null || car.getHorsePower() <= maxHorsePower))
                .filter(car -> (color == null || car.getColor().equalsIgnoreCase(color)))
                .toList();

        List<CarDTO> carDTOs = filteredCars.stream()
                .map(this.carService::convertToDTO)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(carDTOs);
    }
}