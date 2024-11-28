package com.example.DriftRent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String VIN;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String body;
    @Column
    private Integer yearOfManufacture;
    @Column
    private Integer km;
    @Column
    private String fuelType;
    @Column
    private String gearBox;
    @Column
    private Integer cylindricalCapacity;
    @Column
    private Integer horsePower;
    @Column
    private String color;
}