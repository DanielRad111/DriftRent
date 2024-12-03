package com.example.DriftRent.repository;

import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.Car;

public interface AdRepository extends CRUDRepository<Ad, Integer>{
    Ad findAdByCar(Car car);
    Ad findAdByTitle(String title);
}
