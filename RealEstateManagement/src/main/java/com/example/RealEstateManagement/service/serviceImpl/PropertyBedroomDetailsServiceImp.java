package com.example.RealEstateManagement.service.serviceImpl;

import com.example.RealEstateManagement.dto.PropertyBedroomDetailsDTO;
import com.example.RealEstateManagement.mapper.PropertyBedroomDetailsMapper;
import com.example.RealEstateManagement.model.PropertyBedroomDetails;
import com.example.RealEstateManagement.model.PropertyEntity;
import com.example.RealEstateManagement.repo.PropertyBedroomDetailsRepo;
import com.example.RealEstateManagement.repo.PropertyRepo;
import com.example.RealEstateManagement.service.PropertyBedroomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyBedroomDetailsServiceImp  implements PropertyBedroomDetailsService {

    @Autowired
    private PropertyBedroomDetailsRepo repo;

    @Autowired
    private PropertyRepo   propertyRepo;

    @Autowired
    private PropertyBedroomDetailsMapper mapper;


    @Override
    public PropertyBedroomDetailsDTO createBedroomDetails(PropertyBedroomDetailsDTO dto) {
        PropertyEntity propertyEntity = propertyRepo.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        PropertyBedroomDetails entity = mapper.toEntity(dto, propertyEntity);
        return mapper.toDTO(repo.save(entity));
    }

    @Override
    public PropertyBedroomDetailsDTO updateBedroomDetails(Long id, PropertyBedroomDetailsDTO dto) {
        PropertyBedroomDetails existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bedroom details not found"));

        PropertyEntity propertyEntity = propertyRepo.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        existing.setBedrooms(dto.getBedrooms());
        existing.setBathrooms(dto.getBathrooms());
        existing.setBalconies(dto.getBalconies());
        existing.setFloor(dto.getFloor());
        existing.setPropertyEntity(propertyEntity);

        return mapper.toDTO(repo.save(existing));
    }

    @Override
    public PropertyBedroomDetailsDTO getBedroomDetailsById(Long id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Bedroom details not found"));
    }

    @Override
    public List<PropertyBedroomDetailsDTO> getAllBedroomDetails() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBedroomDetails(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Bedroom details not found");
        }
        repo.deleteById(id);
    }
}
