package com.example.RealEstateManagement.mapper;

import com.example.RealEstateManagement.dto.UserDTO;
import com.example.RealEstateManagement.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity entity) {
        if (entity == null) return null;
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .role(entity.getRole())
                .password(entity.getPassword())
                .active(entity.isActive())
                .build();
    }

    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) return null;
        return UserEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .Phone(dto.getPhone())
                .role(dto.getRole())
                .password(dto.getPassword())
                .active(dto.isActive())
                .build();
    }
}
