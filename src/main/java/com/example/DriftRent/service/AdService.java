package com.example.DriftRent.service;

import com.example.DriftRent.model.Ad;

public interface AdService{
    Ad save(Ad ad);
    Ad update(Ad ad);
    Ad findById(Integer id);
    Ad findAdByCar(Integer carId);
    Ad findAdByTitle(String title);
    boolean delete(Ad ad);
}
