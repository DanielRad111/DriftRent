package com.example.DriftRent.dto;

import com.example.DriftRent.model.Car;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for Ad entity.
 */
@Data
public class AdDTO {

    /**
     * Title of the ad.
     */
    private String title;

    /**
     * Description of the ad.
     */
    private String description;

    /**
     * Price of the ad.
     */
    private Double price;

    private Car car;
}