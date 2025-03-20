package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public UserMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public static User toEntity(UserDTO userDTO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        if (userDTO == null) {
           return null; 
        }
        User newUser = new User();

        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        return newUser;
    }

    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO newUserDto = new UserDTO();
        
        newUserDto.setUsername(user.getUsername());
        newUserDto.setPassword(user.getPassword());

        return newUserDto;
    }
}
