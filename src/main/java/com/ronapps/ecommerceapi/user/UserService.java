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

    public void registerNewUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.addRole("ROLE_USER");
        userRepository.save(user);
    }

    public void registerNewAdmin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.addRole("ROLE_ADMIN");
        userRepository.save(user);
    }
}
