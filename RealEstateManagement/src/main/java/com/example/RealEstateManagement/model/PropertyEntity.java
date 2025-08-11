package com.example.RealEstateManagement.model;

import com.example.RealEstateManagement.enumClass.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private BigDecimal price;

    private Integer area;

    @Enumerated(EnumType.STRING)
    private AreaUnit areaUnit;

    private String city;
    private String locality;
    private String state;
    private String zipcode;


    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;


    @Enumerated(EnumType.STRING)
    private ConstructionStatus constructionStatus;

    @Enumerated(EnumType.STRING)
    private FurnishingStatus furnishingStatus;

    @Enumerated(EnumType.STRING)
    private PurchaseType purchaseType;

    @Enumerated(EnumType.STRING)
    private PostedBy postedBy;


    private boolean reraApproved;
    private boolean isVerified;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;


    @OneToMany(mappedBy = "propertyEntity", cascade = CascadeType.ALL)
    private List<PropertyImage> image;


    @ManyToMany
    @JoinTable(
            name = "property_amenities",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<PropertyAmenity> amenities;


    @OneToOne(mappedBy = "propertyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private PropertyBedroomDetails bedroomDetails;



    private LocalDateTime createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }


}
