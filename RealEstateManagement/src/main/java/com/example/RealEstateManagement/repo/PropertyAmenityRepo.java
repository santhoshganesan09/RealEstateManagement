package com.example.RealEstateManagement.repo;

import com.example.RealEstateManagement.model.PropertyAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyAmenityRepo  extends JpaRepository<PropertyAmenity,Long> {

//    boolean existsByName(String name);

    boolean existsByNameIgnoreCase(String name);
}
