package com.example.RealEstateManagement.service.serviceImpl;


import com.example.RealEstateManagement.dto.PropertyTypeDTO;
import com.example.RealEstateManagement.mapper.PropertyTypeMapper;
import com.example.RealEstateManagement.model.PropertyType;
import com.example.RealEstateManagement.repo.PropertyTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyTypeServiceImp {

    @Autowired
    private  PropertyTypeRepo propertyTypeRepo;

    @Autowired
    private PropertyTypeMapper propertyTypeMapper;

    public PropertyTypeDTO createPropertyType(PropertyTypeDTO dto) {
        PropertyType entity = propertyTypeMapper.toEntity(dto);
        PropertyType saved = propertyTypeRepo.save(entity);
        return propertyTypeMapper.toDTO(saved);
    }
}
