package com.example.DriftRent.dto;

import lombok.Data;

@Data
public class CarDTO {
    private Integer id;
    private String VIN;
    private String brand;
    private String model;
    private String body;
    private Integer yearOfManufacture;
    private Integer km;
    private String fuelType;
    private String gearBox;
    private Integer cylindricalCapacity;
    private Integer horsePower;
    private String color;
}