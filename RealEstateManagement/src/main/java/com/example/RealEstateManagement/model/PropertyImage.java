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
public class PropertyImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;  // URL/path to the image (S3, local server, etc.)

    @ManyToOne
    @JoinColumn(name = "Property_id")
    private PropertyEntity propertyEntity;


}
