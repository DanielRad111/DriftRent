package com.example.DriftRent.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private Double rating;
    private List<AdDTO> ads;
}