package com.example.DriftRent.controller;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.model.Ad;
import com.example.DriftRent.model.Car;
import com.example.DriftRent.service.AdService;
import com.example.DriftRent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AdController {
    private final AdService adService;

    @GetMapping("/id/{id}")
    public ResponseEntity<AdDTO> findAdById(@PathVariable Integer id){
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Ad ad = this.adService.findById(id);
        AdDTO adDTO = this.adService.convertTODTO(ad);
        return ResponseEntity.status(HttpStatus.OK).body(adDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<AdDTO> createAd(@RequestBody Ad ad){
        Ad savedAd = this.adService.save(ad);
        AdDTO savedDto = this.adService.convertTODTO(savedAd);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Integer id){
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Ad ad = this.adService.findById(id);
        this.adService.delete(ad);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update")
    public ResponseEntity<AdDTO> updateAd(@RequestBody Ad ad){
        Ad adFromDB = this.adService.findById(ad.getId());
        if(ad.getTitle() != null){
            adFromDB.setTitle(ad.getTitle());
        }
        if(ad.getDescription() != null){
            adFromDB.setDescription(ad.getDescription());
        }
        if(ad.getPrice() != null) {
            adFromDB.setPrice(ad.getPrice());
        }
        if(ad.getCar() != null){
            adFromDB.setCar(ad.getCar());
        }
        Ad updatedAd = this.adService.update(adFromDB);
        AdDTO adDTO = this.adService.convertTODTO(updatedAd);
        return ResponseEntity.status(HttpStatus.OK).body(adDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<AdDTO>> findAllAds() {
        List<Ad> ads = adService.findAll();
        List<AdDTO> adDTOs = ads.stream()
                .map(adService::convertTODTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(adDTOs);
    }

}
