package com.example.RealEstateManagement.mapper;

import com.example.RealEstateManagement.dto.PropertyImageDTO;
import com.example.RealEstateManagement.model.PropertyEntity;
import com.example.RealEstateManagement.model.PropertyImage;
import org.springframework.stereotype.Component;

@Component
public class PropertyImageMapper {

    public static PropertyImageDTO toDTO(PropertyImage image) {
        if (image == null) return null;

        return PropertyImageDTO.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .build();
    }

    public static PropertyImage toEntity(PropertyImageDTO dto) {
        if (dto == null) return null;

        return PropertyImage.builder()
                .id(dto.getId())
                .imageUrl(dto.getImageUrl())
               // .propertyEntity(PropertyEntity())
                .build();
    }

}
