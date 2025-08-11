package com.example.RealEstateManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyBedroomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int bedrooms;
    private int bathrooms;
    private int balconies;
    private int floor;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity propertyEntity;


}
