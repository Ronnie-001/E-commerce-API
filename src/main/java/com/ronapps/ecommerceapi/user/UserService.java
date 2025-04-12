package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void registerNewUser(UserDTO userDto) {
        User newUser = UserMapper.toEntity(userDto, bCryptPasswordEncoder);
        Role role = new Role();
        role.setRole("USER");
        newUser.addRole(role);
        userRepository.save(newUser);
    }

    public void registerNewAdmin(UserDTO userDto) {
        User newAdmin = UserMapper.toEntity(userDto, bCryptPasswordEncoder);
        Role role = new Role();
        role.setRole("ADMIN"); 
        newAdmin.addRole(role);
        userRepository.save(newAdmin);
    }
}
