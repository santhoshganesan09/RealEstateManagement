package com.example.RealEstateManagement.repo;

import com.example.RealEstateManagement.model.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyEntity, Long> {


    List<PropertyEntity> findByCityIgnoreCase(String city);

    List<PropertyEntity> findByPostedBy(com.example.RealEstateManagement.enumClass.PostedBy postedBy);

    // Add more filters as needed
}
