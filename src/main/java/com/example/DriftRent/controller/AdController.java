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

    @GetMapping("/filter")
    public ResponseEntity<List<AdDTO>> filterAds(
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String fuelType,
        @RequestParam(required = false) String gearBox,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) Integer minHorsePower,
        @RequestParam(required = false) Integer maxHorsePower,
        @RequestParam(required = false) Integer minKm,
        @RequestParam(required = false) Integer maxKm,
        @RequestParam(required = false) Integer startYear,
        @RequestParam(required = false) Integer endYear
    ) {
        List<Ad> allAds = adService.findAll();
        
        List<Ad> filteredAds = allAds.stream()
            .filter(ad -> brand == null || ad.getCar().getBrand().equalsIgnoreCase(brand))
            .filter(ad -> fuelType == null || ad.getCar().getFuelType().equalsIgnoreCase(fuelType))
            .filter(ad -> gearBox == null || ad.getCar().getGearBox().equalsIgnoreCase(gearBox))
            .filter(ad -> minPrice == null || ad.getPrice() >= minPrice)
            .filter(ad -> maxPrice == null || ad.getPrice() <= maxPrice)
            .filter(ad -> minHorsePower == null || ad.getCar().getHorsePower() >= minHorsePower)
            .filter(ad -> maxHorsePower == null || ad.getCar().getHorsePower() <= maxHorsePower)
            .filter(ad -> minKm == null || ad.getCar().getKm() >= minKm)
            .filter(ad -> maxKm == null || ad.getCar().getKm() <= maxKm)
            .filter(ad -> startYear == null || ad.getCar().getYearOfManufacture() >= startYear)
            .filter(ad -> endYear == null || ad.getCar().getYearOfManufacture() <= endYear)
            .toList();

        List<AdDTO> adDTOs = filteredAds.stream()
            .map(adService::convertTODTO)
            .toList();

        return ResponseEntity.ok(adDTOs);
    }

}
