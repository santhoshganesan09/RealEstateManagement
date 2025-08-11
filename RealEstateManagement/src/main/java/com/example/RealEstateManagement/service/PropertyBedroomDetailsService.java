package com.example.RealEstateManagement.service;

import com.example.RealEstateManagement.dto.PropertyBedroomDetailsDTO;

import java.util.List;

public interface PropertyBedroomDetailsService {

    PropertyBedroomDetailsDTO createBedroomDetails(PropertyBedroomDetailsDTO dto);

    PropertyBedroomDetailsDTO updateBedroomDetails(Long id, PropertyBedroomDetailsDTO dto);

    PropertyBedroomDetailsDTO getBedroomDetailsById(Long id);

    List<PropertyBedroomDetailsDTO> getAllBedroomDetails();

    void deleteBedroomDetails(Long id);
}
