package com.example.RealEstateManagement.service.serviceImpl;

import com.example.RealEstateManagement.dto.UserDTO;
import com.example.RealEstateManagement.mapper.UserMapper;
import com.example.RealEstateManagement.model.UserEntity;
import com.example.RealEstateManagement.repo.UserRepo;
import com.example.RealEstateManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo  userRepo;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO createUser(UserDTO dto) {
        UserEntity entity = userMapper.toEntity(dto);
        UserEntity saved = userRepo.save(entity);
        return userMapper.toDTO(saved);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepo.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }


}
