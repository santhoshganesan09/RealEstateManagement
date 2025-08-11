package com.example.RealEstateManagement.service.serviceImpl;

import com.example.RealEstateManagement.dto.PropertyDTO;
import com.example.RealEstateManagement.enumClass.PostedBy;
import com.example.RealEstateManagement.mapper.PropertyMapper;
import com.example.RealEstateManagement.model.PropertyAmenity;
import com.example.RealEstateManagement.model.PropertyEntity;
import com.example.RealEstateManagement.model.PropertyImage;
import com.example.RealEstateManagement.repo.PropertyAmenityRepo;
import com.example.RealEstateManagement.repo.PropertyRepo;
import com.example.RealEstateManagement.repo.PropertyTypeRepo;
import com.example.RealEstateManagement.repo.UserRepo;
import com.example.RealEstateManagement.service.PropertyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PropertyServiceImp implements PropertyService {

    @Autowired
    private PropertyRepo  propertyRepo;

    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private PropertyTypeRepo propertyTypeRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PropertyAmenityRepo propertyAmenityRepo;




    @Override   //POST Mapping to create new property
    public PropertyDTO createProperty(PropertyDTO dto) {
        // Map DTO to Entity using mapper
        PropertyEntity entity = propertyMapper.toEntity(dto);

        // Set relationships
        entity.setPropertyType(
                propertyTypeRepo.findById(dto.getPropertyTypeId())
                        .orElseThrow(() -> new RuntimeException("PropertyType not found"))
        );

        entity.setOwner(
                userRepo.findById(dto.getPropertyOwnerId())
                        .orElseThrow(() -> new RuntimeException("User (Owner) not found"))
        );

        // Set Images
        if (dto.getImageUrl() != null) {
            List<PropertyImage> images = dto.getImageUrl().stream().map(url -> {
                PropertyImage img = new PropertyImage();
                img.setImageUrl(url);
                img.setPropertyEntity(entity);
                return img;
            }).collect(Collectors.toList());
            entity.setImage(images);
        }

        // Set Amenities
        if (dto.getAmenityIds() != null) {
            List<PropertyAmenity> amenities = propertyAmenityRepo.findAllById(dto.getAmenityIds());
            entity.setAmenities(amenities);
        }

        // Save and return
        PropertyEntity saved = propertyRepo.save(entity);
        return propertyMapper.toDTO(saved);
    }


    @Override  // GET Mapping to get all the property
    public List<PropertyDTO> getAllProperties() {
        return propertyRepo.findAll()
                .stream().map(propertyMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override // GET Mapping to get property By ID
    public PropertyDTO getPropertyById(Long id) {
        return propertyRepo.findById(id)
                .map(propertyMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }


    @Override //GET Mapping get property By city
    public List<PropertyDTO> getPropertiesByCity(String city) {
        return propertyRepo.findByCityIgnoreCase(city)
                .stream().map(propertyMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override // GET Mapping get property by PostedBY (AGENT, BROKER, OWNER)
    public List<PropertyDTO> getPropertiesByPostedBy(String role) {
        return propertyRepo.findByPostedBy(PostedBy.valueOf(role.toUpperCase()))
                .stream().map(propertyMapper::toDTO)
                .collect(Collectors.toList());
    }
}
