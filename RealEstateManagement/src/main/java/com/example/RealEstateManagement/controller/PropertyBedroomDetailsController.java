package com.example.RealEstateManagement.controller;

import com.example.RealEstateManagement.dto.PropertyBedroomDetailsDTO;
import com.example.RealEstateManagement.service.PropertyBedroomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bedroom-detail")
public class PropertyBedroomDetailsController {

    @Autowired
    private PropertyBedroomDetailsService service;

    @PostMapping
    public ResponseEntity<PropertyBedroomDetailsDTO> create(@RequestBody PropertyBedroomDetailsDTO dto) {
        return ResponseEntity.ok(service.createBedroomDetails(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyBedroomDetailsDTO> update(@PathVariable Long id, @RequestBody PropertyBedroomDetailsDTO dto) {
        return ResponseEntity.ok(service.updateBedroomDetails(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyBedroomDetailsDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBedroomDetailsById(id));
    }

    @GetMapping
    public ResponseEntity<List<PropertyBedroomDetailsDTO>> getAll() {
        return ResponseEntity.ok(service.getAllBedroomDetails());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBedroomDetails(id);
        return ResponseEntity.noContent().build();
    }


}
