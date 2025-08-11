package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.dto.PropertyAmenityDTO;
import com.example.RealEstateManagement.service.AmenityService;
import com.example.RealEstateManagement.service.serviceImpl.PropertyAmenityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class PropertyAmenityController {

    @Autowired
    private AmenityService AmenityService;

    @PostMapping
    public ResponseEntity<PropertyAmenityDTO> create(@RequestBody PropertyAmenityDTO dto) {
        return ResponseEntity.ok(AmenityService.createAmenity(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyAmenityDTO> update(@PathVariable Long id, @RequestBody PropertyAmenityDTO dto) {
        return ResponseEntity.ok(AmenityService.updateAmenity(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        AmenityService.deleteAmenity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PropertyAmenityDTO>> getAll() {
        return ResponseEntity.ok(AmenityService.getAllAmenities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyAmenityDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(AmenityService.getAmenityById(id));
    }


}
