package com.example.RealEstateManagement.service;

import com.example.RealEstateManagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO createProperty(PropertyDTO dto);

    List<PropertyDTO> getAllProperties();

    PropertyDTO getPropertyById(Long id);

    List<PropertyDTO> getPropertiesByCity(String city);

    List<PropertyDTO> getPropertiesByPostedBy(String role); // Agent, Owner, Broker

}
