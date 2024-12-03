package com.example.DriftRent.service.implementation;

import com.example.DriftRent.model.Ad;
import com.example.DriftRent.repository.AdRepository;
import com.example.DriftRent.service.AdService;
import com.example.DriftRent.single_point_access.RepositorySinglePointAccess;

public class AdServiceImpl implements AdService {
    private AdRepository adRepository = RepositorySinglePointAccess.getAdRepository();
    @Override
    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }

    @Override
    public Ad update(Ad ad) {
        return adRepository.update(ad);
    }

    @Override
    public Ad findById(Integer id) {
        return adRepository.findById(id);
    }

    @Override
    public Ad findAdByCar(Integer carId) {
        return null;
    }

    @Override
    public Ad findAdByTitle(String title) {
        return null;
    }

    @Override
    public boolean delete(Ad ad) {
        return adRepository.delete(ad);
    }
}
