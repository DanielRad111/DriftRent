package com.example.DriftRent.mappers;

import com.example.DriftRent.dto.AdDTO;
import com.example.DriftRent.model.Ad;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
@Component
@Mapper
public interface AdMapper {

    Ad toEntity(AdDTO adEntity);
    AdDTO toDTO(Ad adEntity);
}
