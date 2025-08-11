package com.example.RealEstateManagement.dto;

import com.example.RealEstateManagement.enumClass.*;
import com.example.RealEstateManagement.model.PropertyBedroomDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer area;
    private AreaUnit areaUnit;
    private String city;
    private String locality;
    private String state;
    private String zipcode;

    private Long propertyTypeId;
    private ConstructionStatus constructionStatus;
    private FurnishingStatus  furnishingStatus;
    private PurchaseType  purchaseType;
    private PostedBy postedBy;

    private boolean reraApproved;
    private boolean isVerified;


    private Long propertyOwnerId;

    private List<String> imageUrl;
    private List<Long> amenityIds;

    // Optional
    private PropertyBedroomDetailsDTO  bedroomDetails;

    private LocalDateTime createdAt;




}
