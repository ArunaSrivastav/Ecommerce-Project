package com.ecom.user.dto;

import com.ecom.user.enums.RoleType;
import lombok.Data;

@Data
public class UserResponseDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private RoleType role;
    private AddressDTO address;
}
