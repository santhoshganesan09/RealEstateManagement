package com.example.RealEstateManagement.mapper;

import com.example.RealEstateManagement.dto.PropertyAmenityDTO;
import com.example.RealEstateManagement.model.PropertyAmenity;
import org.springframework.stereotype.Component;


@Component
public class PropertyAmenityMapper {

    public  PropertyAmenityDTO toDTO(PropertyAmenity amenity) {
        PropertyAmenityDTO dto = new PropertyAmenityDTO();
        dto.setId(amenity.getId());
        dto.setName(amenity.getName());
        return dto;
    }

    public  PropertyAmenity toEntity(PropertyAmenityDTO dto) {
        PropertyAmenity entity = new PropertyAmenity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }


}
