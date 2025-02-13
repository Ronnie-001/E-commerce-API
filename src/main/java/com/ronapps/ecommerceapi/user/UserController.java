package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String greeting() {
        return "client needs to create a user first to purchase products";
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        userService.registerNewUser(user.getUsername(), user.getPassword());
        return user;
    }

    @GetMapping("/login")
    public String userLogin(String username, String password) {
        // TODO: Search user database to find an entity with the correct user and password
        // TODO: Also need to authenticate user login
        return "Login successful.";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/basket")
    public String addToBasket() {

    }
}
