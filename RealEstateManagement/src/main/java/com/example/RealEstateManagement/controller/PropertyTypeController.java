package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.dto.PropertyTypeDTO;
import com.example.RealEstateManagement.service.serviceImpl.PropertyTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/property-type")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeServiceImp propertyTypeService;

    @PostMapping
    public ResponseEntity<PropertyTypeDTO> createPropertyType(@RequestBody PropertyTypeDTO dto) {
        PropertyTypeDTO savedType = propertyTypeService.createPropertyType(dto);
        return ResponseEntity.ok(savedType);
    }
}
