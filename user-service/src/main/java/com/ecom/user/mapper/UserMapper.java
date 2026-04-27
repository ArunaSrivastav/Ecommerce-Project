package com.ecom.user.mapper;

import com.ecom.user.dto.UserRequestDTO;
import com.ecom.user.dto.UserResponseDTO;
import com.ecom.user.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserResponseDTO userToUserResponseDTO(User user);
    User userRequestDTOToUser(UserRequestDTO userDTO);

}
