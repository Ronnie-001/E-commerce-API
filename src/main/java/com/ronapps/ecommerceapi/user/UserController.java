package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String greeting() {
        return "client needs to create a user first to purchase products";
    }
    
    @PostMapping("/register_user")
    public UserDTO createUser(@RequestBody UserDTO userDto) {
        userService.registerNewUser(userDto);
        return userDto;
    }

    @PostMapping("/register_admin")
    public UserDTO createAdmin(@RequestBody UserDTO userDto) {
        userService.registerNewAdmin(userDto);
        return userDto;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok("Login sucsessfull!");
        } else {
            return ResponseEntity.ok("User doesn't exist.");
        }
    }
}
