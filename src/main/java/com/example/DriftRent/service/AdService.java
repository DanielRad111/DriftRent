//package com.example.DriftRent.service;
//
//import com.example.DriftRent.dto.AdDTO;
//import com.example.DriftRent.mappers.AdMapper;
//import com.example.DriftRent.model.Ad;
//import com.example.DriftRent.repository.AdRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AdService {
//    @Autowired
//    private final AdRepository adRepository;
////    @Autowired
////    private  final AdMapper adMapper;
//
//    public AdDTO save(AdDTO adDTO) {
//        Ad adEntity = this.adMapper.toEntity(adDTO);
//        var savedEntity =  adRepository.save(adEntity);
//        AdDTO savedDTO = this.adMapper.toDTO(savedEntity);
////        savedDTO.toBuilder()
////                .price()
////                .id()
////                .build();
//        return savedDTO;
//    }
//
//    public Ad update(Ad ad) {
//        return adRepository.save(ad);
//    }
//
//    public Ad findById(Integer id) {
//        return adRepository.findById(id).get();
//    }
//
//    public void delete(Ad ad) {
//        adRepository.delete(ad);
//    }
//}
