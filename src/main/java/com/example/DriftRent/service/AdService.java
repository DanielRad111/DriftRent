package com.example.DriftRent.service;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.dto.CarDTO;
import com.example.DriftRent.model.Ad;
import com.example.DriftRent.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdService {
    private final AdRepository adRepository;
    private final CarService carService;

    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }

    public Ad update(Ad ad) {
        return adRepository.save(ad);
    }

    public Ad findById(Integer id) {
        return adRepository.findById(id).get();
    }

    public void delete(Ad ad) {
        adRepository.delete(ad);
    }

    public AdDTO convertTODTO(Ad ad) {
        AdDTO adDTO = new AdDTO();
        adDTO.setId(ad.getId());
        adDTO.setTitle(ad.getTitle());
        adDTO.setDescription(ad.getDescription());
        adDTO.setPrice(ad.getPrice());
        adDTO.setCarDTO(carService.convertToDTO(ad.getCar()));
        adDTO.setUserEmail(ad.getUser().getEmail());
        adDTO.setOwnerFirstName(ad.getUser().getFirstName());
        adDTO.setOwnerLastName(ad.getUser().getLastName());
        return adDTO;
    }
    public List<Ad> findAll() {
        return adRepository.findAll();
    }

}