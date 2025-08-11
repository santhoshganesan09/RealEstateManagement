package com.example.RealEstateManagement.dto;

import com.example.RealEstateManagement.enumClass.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private UserRole role;
    private String password;
    private boolean active;
}
