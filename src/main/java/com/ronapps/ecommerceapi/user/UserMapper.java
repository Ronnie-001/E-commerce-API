package com.ronapps.ecommerceapi.user;


public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
           return null; 
        }
        User newUser = new User();

        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

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
