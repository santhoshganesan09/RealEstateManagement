package com.example.RealEstateManagement.mapper;

import com.example.RealEstateManagement.dto.PropertyBedroomDetailsDTO;
import com.example.RealEstateManagement.model.PropertyBedroomDetails;
import com.example.RealEstateManagement.model.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyBedroomDetailsMapper {

    public PropertyBedroomDetailsDTO toDTO(PropertyBedroomDetails entity) {
        if (entity == null) return null;

        return PropertyBedroomDetailsDTO.builder()
                .id(entity.getId())
                .bedrooms(entity.getBedrooms())
                .bathrooms(entity.getBathrooms())
                .balconies(entity.getBalconies())
                .floor(entity.getFloor())
                .propertyId(entity.getPropertyEntity() != null ? entity.getPropertyEntity().getId() : null)
                .build();
    }

    public PropertyBedroomDetails toEntity(PropertyBedroomDetailsDTO dto, PropertyEntity propertyEntity) {
        if (dto == null) return null;

        return PropertyBedroomDetails.builder()
                .id(dto.getId())
                .bedrooms(dto.getBedrooms())
                .bathrooms(dto.getBathrooms())
                .balconies(dto.getBalconies())
                .floor(dto.getFloor())
                .propertyEntity(propertyEntity)
                .build();
    }
}
