package com.example.RealEstateManagement.mapper;

import com.example.RealEstateManagement.dto.PropertyTypeDTO;
import com.example.RealEstateManagement.model.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PropertyTypeMapper {

    public  PropertyTypeDTO toDTO(PropertyType entity) {
        PropertyTypeDTO dto = new PropertyTypeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public  PropertyType toEntity(PropertyTypeDTO dto) {
        PropertyType entity = new PropertyType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

}
