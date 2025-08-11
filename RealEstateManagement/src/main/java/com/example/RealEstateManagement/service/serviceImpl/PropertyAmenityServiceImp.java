package com.example.RealEstateManagement.service.serviceImpl;

import com.example.RealEstateManagement.dto.PropertyAmenityDTO;
import com.example.RealEstateManagement.mapper.PropertyAmenityMapper;
import com.example.RealEstateManagement.model.PropertyAmenity;
import com.example.RealEstateManagement.repo.PropertyAmenityRepo;
import com.example.RealEstateManagement.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyAmenityServiceImp  implements AmenityService {

    @Autowired
    private PropertyAmenityRepo AmenityRepo;

    @Autowired
    private PropertyAmenityMapper  mapper;

    @Override
    public PropertyAmenityDTO createAmenity(PropertyAmenityDTO dto) {
        if (AmenityRepo.existsByNameIgnoreCase(dto.getName())) {
            throw new RuntimeException("Amenity with this name already exists");
        }
        PropertyAmenity entity = mapper.toEntity(dto);
        return mapper.toDTO(AmenityRepo.save(entity));
    }

    @Override
    public PropertyAmenityDTO updateAmenity(Long id, PropertyAmenityDTO dto) {
        PropertyAmenity existing = AmenityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found"));
        existing.setName(dto.getName());
        return mapper.toDTO(AmenityRepo.save(existing));
    }


    @Override
    public void deleteAmenity(Long id) {
        AmenityRepo.deleteById(id);
    }

    @Override
    public List<PropertyAmenityDTO> getAllAmenities() {
        return AmenityRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyAmenityDTO getAmenityById(Long id) {

        return AmenityRepo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Amenity not found"));
    }
}

