package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerNewUser(UserDTO userDto) {
        User newUser = UserMapper.toEntity(userDto);
        Role role = new Role();
        role.setRole("USER");
        newUser.addRole(role);
        userRepository.save(newUser);
    }

    public void registerNewAdmin(UserDTO userDto) {
        User newUser = UserMapper.toEntity(userDto);
        Role role = new Role();
        role.setRole("ADMIN"); 
        newUser.addRole(role);
        userRepository.save(newUser);
    }
}
