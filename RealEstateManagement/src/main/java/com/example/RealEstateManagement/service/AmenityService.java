package com.example.RealEstateManagement.service;

import com.example.RealEstateManagement.dto.PropertyAmenityDTO;
import org.springframework.data.mapping.model.Property;

import java.util.List;

public interface AmenityService {

    PropertyAmenityDTO createAmenity(PropertyAmenityDTO dto);

    PropertyAmenityDTO updateAmenity(Long id, PropertyAmenityDTO dto);

    void deleteAmenity(Long id);

    List<PropertyAmenityDTO> getAllAmenities();

    PropertyAmenityDTO getAmenityById(Long id);
}

