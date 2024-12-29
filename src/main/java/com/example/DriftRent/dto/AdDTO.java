package com.example.DriftRent.dto;

import com.example.DriftRent.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Data Transfer Object (DTO) for Ad entity.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AdDTO {
    private Integer id;
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

    private CarDTO carDTO;
}