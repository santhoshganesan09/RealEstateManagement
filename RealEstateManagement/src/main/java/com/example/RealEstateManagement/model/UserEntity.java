package com.example.RealEstateManagement.model;

import com.example.RealEstateManagement.enumClass.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String Phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;  // AGENT, OWNER, BROKER, BUYER

    private String password; // Optional if using auth

    private boolean active;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<PropertyEntity> propertyEntities;



}
