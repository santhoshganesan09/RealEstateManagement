package com.example.RealEstateManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyBedroomDetailsDTO {

    private Long id;
    private int bedrooms;
    private int bathrooms;
    private int balconies;
    private int floor;

    private Long propertyId; // Store only ID instead of full PropertyEntity

}
