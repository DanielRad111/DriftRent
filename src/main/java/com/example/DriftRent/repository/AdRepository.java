package com.example.DriftRent.repository;

import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Integer> {
    Ad findAdByCar(Car car);
    Ad findAdByTitle(String title);
}
