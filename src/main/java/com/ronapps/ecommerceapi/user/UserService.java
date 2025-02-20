package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // TODO: Pass UserDTO Objectas param instead
    public void registerNewUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.addRole("USER");
        userRepository.save(user);
    }
}
