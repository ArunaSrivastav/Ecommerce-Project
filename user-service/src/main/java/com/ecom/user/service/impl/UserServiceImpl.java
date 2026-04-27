package com.ecom.user.service.impl;

import com.ecom.user.dto.UserRequestDTO;
import com.ecom.user.dto.UserResponseDTO;
import com.ecom.user.entity.User;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;
import com.ecom.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
  /*  private final PasswordEncoder passwordEncoder;*/

    @Override
    public User createUser(UserRequestDTO userDTO){
   //   String hashPwd = passwordEncoder.encode(userDTO.getPassword());
       // userDTO.setPassword(hashPwd);
        return userRepository.save(UserMapper.USER_MAPPER.userRequestDTOToUser(userDTO));


  // return UserMapper.USER_MAPPER.userToUserResponseDTO(userRepository.save(UserMapper.USER_MAPPER.userRequestDTOToUser(userDTO)));
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper.USER_MAPPER ::userToUserResponseDTO).toList();
    }
}
