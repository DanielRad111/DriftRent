package com.example.DriftRent.controller;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.model.Ad;
import com.example.DriftRent.service.AdService;
import com.example.DriftRent.single_point_access.ServiceSinglePointAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ad")
public class AdController {
    private AdService adService = ServiceSinglePointAccess.getAdService();

    @PostMapping("/create")
    public ResponseEntity<AdDTO> createAd(@RequestBody Ad ad){
        Ad savedAd = adService.save(ad);
        AdDTO adDTO = convertToDTO(savedAd);
        return ResponseEntity.status(HttpStatus.CREATED).body(adDTO);
    }

    private AdDTO convertToDTO(Ad ad){
        AdDTO adDTO = new AdDTO();
        adDTO.setTitle(ad.getTitle());
        adDTO.setDescription(ad.getDescription());
        adDTO.setPrice(ad.getPrice());
        adDTO.setCar(ad.getCar());
        return adDTO;
    }
}
