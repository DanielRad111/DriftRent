package com.example.DriftRent.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for Car entity.
 */
@Data
public class CarDTO {

    /**
     * Unique identifier for the car.
     */
    private Integer id;

    /**
     * Vehicle Identification Number (VIN) of the car.
     */
    private String VIN;

    /**
     * Brand of the car.
     */
    private String brand;

    /**
     * Model of the car.
     */
    private String model;

    /**
     * Body type of the car.
     */
    private String body;

    /**
     * Year the car was manufactured.
     */
    private Integer yearOfManufacture;

    /**
     * Kilometers driven by the car.
     */
    private Integer km;

    /**
     * Type of fuel used by the car.
     */
    private String fuelType;

    /**
     * Type of gearbox in the car.
     */
    private String gearBox;

    /**
     * Cylindrical capacity of the car's engine.
     */
    private Integer cylindricalCapacity;

    /**
     * Horsepower of the car's engine.
     */
    private Integer horsePower;

    /**
     * Color of the car.
     */
    private String color;
}