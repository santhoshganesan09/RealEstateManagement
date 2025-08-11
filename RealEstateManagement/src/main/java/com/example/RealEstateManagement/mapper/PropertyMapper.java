package com.example.RealEstateManagement.mapper;


import com.example.RealEstateManagement.dto.PropertyBedroomDetailsDTO;
import com.example.RealEstateManagement.dto.PropertyDTO;
import com.example.RealEstateManagement.model.PropertyAmenity;
import com.example.RealEstateManagement.model.PropertyBedroomDetails;
import com.example.RealEstateManagement.model.PropertyEntity;
import com.example.RealEstateManagement.model.PropertyImage;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyMapper {

    public PropertyDTO toDTO(PropertyEntity entity){
        if (entity == null) return null;
        return PropertyDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .area(entity.getArea())
                .areaUnit(entity.getAreaUnit())
                .city(entity.getCity())
                .locality(entity.getLocality())
                .state(entity.getState())
                .zipcode(entity.getZipcode())

                .propertyTypeId(entity.getPropertyType().getId())
                .constructionStatus(entity.getConstructionStatus())
                .furnishingStatus(entity.getFurnishingStatus())
                .purchaseType(entity.getPurchaseType())
                .postedBy(entity.getPostedBy())
                .reraApproved(entity.isReraApproved())
                .isVerified(entity.isVerified())
                .propertyOwnerId(entity.getOwner() != null ? entity.getOwner().getId() : null)

                .imageUrl(entity.getImage() != null
                        ? entity.getImage().stream()
                        .map(PropertyImage::getImageUrl)
                        .collect(Collectors.toList())
                        : Collections.emptyList())

                .amenityIds(entity.getAmenities() != null
                        ? entity.getAmenities().stream()
                        .map(PropertyAmenity::getId)
                        .collect(Collectors.toList())
                        : Collections.emptyList())

                .bedroomDetails(toBedroomDetailsDTO(entity.getBedroomDetails()))
                .createdAt(entity.getCreatedAt())
                .build();
    }


    // Convert DTO to Entity
    public PropertyEntity toEntity(PropertyDTO dto) {
        if (dto == null) return null;

        PropertyEntity entity = new PropertyEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setArea(dto.getArea());
        entity.setAreaUnit(dto.getAreaUnit());
        entity.setCity(dto.getCity());
        entity.setLocality(dto.getLocality());
        entity.setState(dto.getState());
        entity.setZipcode(dto.getZipcode());
        entity.setConstructionStatus(dto.getConstructionStatus());
        entity.setFurnishingStatus(dto.getFurnishingStatus());
        entity.setPurchaseType(dto.getPurchaseType());
        entity.setPostedBy(dto.getPostedBy());
        entity.setReraApproved(dto.isReraApproved());
        entity.setVerified(dto.isVerified());

        // Images
        if (dto.getImageUrl() != null) {
            List<PropertyImage> images = dto.getImageUrl().stream()
                    .map(url -> {
                        PropertyImage img = new PropertyImage();
                        img.setImageUrl(url);
                        img.setPropertyEntity(entity); // set relation
                        return img;
                    })
                    .collect(Collectors.toList());
            entity.setImage(images);
        }

        // Amenities
        if (dto.getAmenityIds() != null) {
            List<PropertyAmenity> amenities = dto.getAmenityIds().stream()
                    .map(id -> {
                        PropertyAmenity amenity = new PropertyAmenity();
                        amenity.setId(id);
                        return amenity;
                    })
                    .collect(Collectors.toList());
            entity.setAmenities(amenities);
        }

        // Bedroom Details
        if (dto.getBedroomDetails() != null) {
            PropertyBedroomDetails details = new PropertyBedroomDetails();
            details.setBedrooms(dto.getBedroomDetails().getBedrooms());
            details.setBathrooms(dto.getBedroomDetails().getBathrooms());
            details.setBalconies(dto.getBedroomDetails().getBalconies());
            details.setFloor(dto.getBedroomDetails().getFloor());
            details.setPropertyEntity(entity); // set relation
            entity.setBedroomDetails(details);
        }

        return entity;
    }


    public PropertyBedroomDetailsDTO toBedroomDetailsDTO(PropertyBedroomDetails details) {
        if (details == null) return null;
        return PropertyBedroomDetailsDTO.builder()
                .id(details.getId())
                .bedrooms(details.getBedrooms())
                .bathrooms(details.getBathrooms())
                .balconies(details.getBalconies())
                .floor(details.getFloor())
                .build();
    }
}
