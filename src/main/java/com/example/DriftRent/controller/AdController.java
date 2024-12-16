package com.example.DriftRent.controller;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AdController {
    private final AdService adService;


    @PostMapping("/create")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO){
        AdDTO savedDTO = this.adService.save(adDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    }
}
