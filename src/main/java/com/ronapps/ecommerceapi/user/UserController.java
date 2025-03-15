package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final MyUserDetailsService myUserDetailsService;
    
    // Use this to persist user login across different endpoints
    private final SecurityContextRepository securityContextRepository;  


    @Autowired
    public UserController(UserService userService, MyUserDetailsService myUserDetailsService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.myUserDetailsService = myUserDetailsService;
        this.securityContextRepository = securityContextRepository;

    }

    @GetMapping("/home")
    public String greeting() {
        return "User needs to create a user first to purchase products";
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

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password) {  
        if (myUserDetailsService.loadUserByUsername(username) != null &&
            myUserDetailsService.loadUserByUsername(username).getPassword().equals(password)) {
            return ResponseEntity.ok("Login sucsessfull!");
        } else {
            return ResponseEntity.ok("User doesn't exist.");
        }
    }

    @GetMapping()
    public String logout() {
        return "This is the logout endpoint";
    }
}
