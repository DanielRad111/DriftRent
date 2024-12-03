package com.example.DriftRent.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a car entity in the DriftRent application.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {

    /**
     * Unique identifier for the car.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Vehicle Identification Number (VIN) of the car.
     */
    @Column(nullable = false, unique = true)
    private String VIN;

    /**
     * Brand of the car.
     */
    @Column
    private String brand;

    /**
     * Model of the car.
     */
    @Column
    private String model;

    /**
     * Body type of the car.
     */
    @Column
    private String body;

    /**
     * Year the car was manufactured.
     */
    @Column
    private Integer yearOfManufacture;

    /**
     * Kilometers driven by the car.
     */
    @Column
    private Integer km;

    /**
     * Type of fuel used by the car.
     */
    @Column
    private String fuelType;

    /**
     * Type of gearbox in the car.
     */
    @Column
    private String gearBox;

    /**
     * Cylindrical capacity of the car's engine.
     */
    @Column
    private Integer cylindricalCapacity;

    /**
     * Horsepower of the car's engine.
     */
    @Column
    private Integer horsePower;

    /**
     * Color of the car.
     */
    @Column
    private String color;

    /**
     * The ad associated with the car.
     */
    @OneToOne(mappedBy = "car")
    private Ad ad;
}