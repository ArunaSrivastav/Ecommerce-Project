package com.ecom.user.service;


import com.ecom.user.dto.UserRequestDTO;
import com.ecom.user.dto.UserResponseDTO;
import com.ecom.user.entity.User;


import java.util.List;

public interface UserService {
    User createUser(UserRequestDTO userDTO);
    List<UserResponseDTO> getAllUsers();
}
