package com.example.RealEstateManagement.controller;


import com.example.RealEstateManagement.dto.PropertyDTO;
import com.example.RealEstateManagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok(propertyService.createProperty(propertyDTO));
    }

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<PropertyDTO>> getPropertiesByCity(@PathVariable String city) {
        return ResponseEntity.ok(propertyService.getPropertiesByCity(city));
    }

    @GetMapping("/postedBy/{role}")
    public ResponseEntity<List<PropertyDTO>> getPropertiesByPostedBy(@PathVariable String role) {
        return ResponseEntity.ok(propertyService.getPropertiesByPostedBy(role));
    }
}
