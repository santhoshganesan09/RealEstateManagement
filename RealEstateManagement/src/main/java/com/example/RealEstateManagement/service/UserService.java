package com.example.RealEstateManagement.service;


import com.example.RealEstateManagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
}
